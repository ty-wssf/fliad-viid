/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { FC, useContext, useEffect, useState } from 'react';

import classnames from 'classnames';
import { WorkflowInputs, WorkflowOutputs } from '@flowgram.ai/runtime-interface';
import { useService } from '@flowgram.ai/free-layout-editor';
import { Button, SideSheet, Switch } from '@douyinfe/semi-ui';
import { IconClose, IconPlay, IconSpin } from '@douyinfe/semi-icons';

import { TestRunJsonInput } from '../testrun-json-input';
import { TestRunForm } from '../testrun-form';
import { NodeStatusGroup } from '../node-status-bar/group';
import { WorkflowRuntimeService } from '../../../plugins/runtime-plugin/runtime-service';
import { SidebarContext } from '../../../context';
import { IconCancel } from '../../../assets/icon-cancel';

import styles from './index.module.less';

interface TestRunSidePanelProps {
  visible: boolean;
  onCancel: () => void;
}

export const TestRunSidePanel: FC<TestRunSidePanelProps> = ({ visible, onCancel }) => {
  const runtimeService = useService(WorkflowRuntimeService);
  const { nodeId: sidebarNodeId, setNodeId } = useContext(SidebarContext);

  const [isRunning, setRunning] = useState(false);
  const [values, setValues] = useState<Record<string, unknown>>({});
  const [errors, setErrors] = useState<string[]>();
  const [result, setResult] = useState<
    | {
        inputs: WorkflowInputs;
        outputs: WorkflowOutputs;
      }
    | undefined
  >();

  // en - Use localStorage to persist the JSON mode state
  const [inputJSONMode, _setInputJSONMode] = useState(() => {
    const savedMode = localStorage.getItem('testrun-input-json-mode');
    return savedMode ? JSON.parse(savedMode) : false;
  });

  const setInputJSONMode = (checked: boolean) => {
    _setInputJSONMode(checked);
    localStorage.setItem('testrun-input-json-mode', JSON.stringify(checked));
  };

  const onTestRun = async () => {
    if (isRunning) {
      await runtimeService.taskCancel();
      return;
    }
    setResult(undefined);
    setErrors(undefined);
    const taskID = await runtimeService.taskRun(values);
    if (taskID) {
      setRunning(true);
    }
  };

  const onClose = async () => {
    await runtimeService.taskCancel();
    setValues({});
    setRunning(false);
    onCancel();
  };

  // runtime effect
  useEffect(() => {
    setNodeId(undefined);
    const disposer = runtimeService.onResultChanged(({ result, errors }) => {
      setRunning(false);
      setResult(result);
      if (errors) {
        setErrors(errors);
      } else {
        setErrors(undefined);
      }
    });
    return () => disposer.dispose();
  }, []);

  // sidebar effect
  useEffect(() => {
    if (sidebarNodeId) {
      onCancel();
    }
  }, [sidebarNodeId]);

  const renderRunning = (
    <div className={styles['testrun-panel-running']}>
      <IconSpin spin size="large" />
      <div className={styles.text}>Running...</div>
    </div>
  );

  const renderForm = (
    <div className={styles['testrun-panel-form']}>
      <div className={styles['testrun-panel-input']}>
        <div className={styles.title}>Input Form</div>
        <div>JSON Mode</div>
        <Switch
          checked={inputJSONMode}
          onChange={(checked: boolean) => setInputJSONMode(checked)}
          size="small"
        />
      </div>
      {inputJSONMode ? (
        <TestRunJsonInput values={values} setValues={setValues} />
      ) : (
        <TestRunForm values={values} setValues={setValues} />
      )}
      {errors?.map((e) => (
        <div className={styles.error} key={e}>
          {e}
        </div>
      ))}
      <NodeStatusGroup title="Inputs Result" data={result?.inputs} optional disableCollapse />
      <NodeStatusGroup title="Outputs Result" data={result?.outputs} optional disableCollapse />
    </div>
  );

  const renderButton = (
    <Button
      onClick={onTestRun}
      icon={isRunning ? <IconCancel /> : <IconPlay size="small" />}
      className={classnames(styles.button, {
        [styles.running]: isRunning,
        [styles.default]: !isRunning,
      })}
    >
      {isRunning ? '取消' : '试运行'}
    </Button>
  );

  return (
    <SideSheet
      title="试运行"
      visible={visible}
      mask={false}
      motion={false}
      onCancel={onClose}
      width={400}
      headerStyle={{
        display: 'none',
      }}
      bodyStyle={{
        padding: 0,
      }}
      style={{
        background: 'none',
        boxShadow: 'none',
      }}
    >
      <div className={styles['testrun-panel-container']}>
        <div className={styles['testrun-panel-header']}>
          <div className={styles['testrun-panel-title']}>试运行</div>
          <Button
            className={styles['testrun-panel-title']}
            type="tertiary"
            icon={<IconClose />}
            size="small"
            theme="borderless"
            onClick={onClose}
          />
        </div>
        <div className={styles['testrun-panel-content']}>
          {isRunning ? renderRunning : renderForm}
        </div>
        <div className={styles['testrun-panel-footer']}>{renderButton}</div>
      </div>
    </SideSheet>
  );
};
