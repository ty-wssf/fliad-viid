/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { Field } from '@flowgram.ai/free-layout-editor';
import { IFlowValue, DynamicValueInput } from '@flowgram.ai/form-materials';
import { Select, InputNumber } from '@douyinfe/semi-ui';

import { useNodeRenderContext } from '../../../hooks';
import { FormItem } from '../../../form-components';

const DB_TYPE_OPTIONS = [
  {
    label: 'MySQL',
    value: 'mysql',
  },
  {
    label: 'PostgreSQL',
    value: 'postgresql',
  },
  {
    label: 'Oracle',
    value: 'oracle',
  },
  {
    label: 'SQL Server',
    value: 'sqlserver',
  },
];

export function Connection() {
  const { readonly } = useNodeRenderContext();

  return (
    <div>
      <FormItem name="数据库类型" required vertical type="string">
        <Field<string> name="connection.type" defaultValue="mysql">
          {({ field }) => (
            <Select
              value={field.value}
              onChange={(value) => {
                field.onChange(value as string);
              }}
              style={{ width: '100%' }}
              size="small"
              disabled={readonly}
              optionList={DB_TYPE_OPTIONS}
            />
          )}
        </Field>
      </FormItem>
      
      <FormItem name="主机地址" required vertical type="string">
        <Field<IFlowValue> name="connection.host">
          {({ field }) => (
            <DynamicValueInput
              readonly={readonly}
              style={{ width: '100%' }}
              value={field.value as any}
              onChange={(value) => {
                field.onChange(value!);
              }}
            />
          )}
        </Field>
      </FormItem>
      
      <FormItem name="端口号" required vertical type="number">
        <Field<number> name="connection.port" defaultValue={3306}>
          {({ field }) => (
            <InputNumber
              size="small"
              value={field.value}
              onChange={(value) => {
                field.onChange(value as number);
              }}
              disabled={readonly}
              style={{ width: '100%' }}
              min={1}
              max={65535}
            />
          )}
        </Field>
      </FormItem>
      
      <FormItem name="数据库名" required vertical type="string">
        <Field<IFlowValue> name="connection.database">
          {({ field }) => (
            <DynamicValueInput
              readonly={readonly}
              style={{ width: '100%' }}
              value={field.value as any}
              onChange={(value) => {
                field.onChange(value!);
              }}
            />
          )}
        </Field>
      </FormItem>
      
      <FormItem name="用户名" required vertical type="string">
        <Field<IFlowValue> name="connection.username">
          {({ field }) => (
            <DynamicValueInput
              readonly={readonly}
              style={{ width: '100%' }}
              value={field.value as any}
              onChange={(value) => {
                field.onChange(value!);
              }}
            />
          )}
        </Field>
      </FormItem>
      
      <FormItem name="密码" required vertical type="string">
        <Field<IFlowValue> name="connection.password">
          {({ field }) => (
            <DynamicValueInput
              readonly={readonly}
              style={{ width: '100%' }}
              value={field.value as any}
              onChange={(value) => {
                field.onChange(value!);
              }}
            />
          )}
        </Field>
      </FormItem>
    </div>
  );
}
