/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { Field } from '@flowgram.ai/free-layout-editor';
import {
  IFlowValue,
  InputsValues,
  DisplayInputsValues,
  DynamicValueInput,
} from '@flowgram.ai/form-materials';
import { Select } from '@douyinfe/semi-ui';

import { useIsSidebar, useNodeRenderContext } from '../../../hooks';
import { FormItem } from '../../../form-components';

const QUERY_TYPE_OPTIONS = [
  {
    label: 'SQL语句',
    value: 'sql',
  },
  {
    label: '简单插入',
    value: 'params',
  },
];

export function Query() {
  const { readonly } = useNodeRenderContext();
  const isSidebar = useIsSidebar();

  return (
    <Field<string> name="query.queryType" defaultValue="params">
      {({ field }) => (
        <div style={{ marginTop: 5 }}>
          <FormItem name="写入方式" vertical type="object">
            <Select
              value={field.value}
              onChange={(value) => {
                field.onChange(value as string);
              }}
              style={{ width: '100%', marginBottom: 10 }}
              disabled={readonly}
              size="small"
              optionList={QUERY_TYPE_OPTIONS}
            />
            
            {field.value === 'sql' ? (
              <Field<IFlowValue> name="query.sql">
                {({ field }) => (
                  <DynamicValueInput
                    readonly={readonly}
                    style={{ width: '100%', minHeight: 100 }}
                    placeholder="请输入SQL语句，使用 '{' 引用变量"
                    value={field.value}
                    onChange={(value) => {
                      field.onChange(value!);
                    }}
                  />
                )}
              </Field>
            ) : (
              <div>
                <FormItem name="表名" required vertical type="string">
                  <Field<IFlowValue> name="query.table">
                    {({ field }) => (
                      <DynamicValueInput
                        readonly={readonly}
                        style={{ width: '100%' }}
                        placeholder="请输入表名，使用 '{' 引用变量"
                        value={field.value}
                        onChange={(value) => {
                          field.onChange(value!);
                        }}
                      />
                    )}
                  </Field>
                </FormItem>
                
                <FormItem name="字段配置" vertical type="object">
                  <Field<Record<string, IFlowValue | undefined> | undefined> name="fields">
                    {({ field }) => 
                      isSidebar ? (
                        <InputsValues
                          value={field.value}
                          onChange={(value) => field.onChange(value)}
                          readonly={readonly}
                        />
                      ) : (
                        <DisplayInputsValues value={field.value} />
                      )
                    }
                  </Field>
                </FormItem>
              </div>
            )}
          </FormItem>
        </div>
      )}
    </Field>
  );
}