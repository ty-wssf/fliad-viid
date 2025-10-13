/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { FlowNodeJSON } from '@flowgram.ai/free-layout-editor';
import { IFlowTemplateValue, IJsonSchema, IFlowValue } from '@flowgram.ai/form-materials';

export interface DatabaseNodeJSON extends FlowNodeJSON {
  data: {
    title: string;
    outputs: IJsonSchema<'object'>;
    connection: {
      host: IFlowTemplateValue;
      port: number;
      database: IFlowTemplateValue;
      username: IFlowTemplateValue;
      password: IFlowTemplateValue;
      type: 'mysql' | 'postgresql' | 'oracle' | 'sqlserver';
    };
    query: {
      queryType: 'sql' | 'params';
      sql?: IFlowTemplateValue;
      table?: IFlowTemplateValue;
    };
    fields: Record<string, IFlowValue | undefined>;
  };
}