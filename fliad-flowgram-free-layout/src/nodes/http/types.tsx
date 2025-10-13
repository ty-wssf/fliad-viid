/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { IFlowConstantRefValue } from '@flowgram.ai/runtime-interface';
import { FlowNodeJSON } from '@flowgram.ai/free-layout-editor';
import { IFlowTemplateValue, IJsonSchema } from '@flowgram.ai/form-materials';

export interface HTTPNodeJSON extends FlowNodeJSON {
  data: {
    title: string;
    outputs: IJsonSchema<'object'>;
    api: {
      method: 'GET' | 'POST' | 'PUT' | 'DELETE' | 'PATCH' | 'HEAD';
      url: IFlowTemplateValue;
    };
    headers: IJsonSchema<'object'>;
    headersValues: Record<string, IFlowConstantRefValue>;
    params: IJsonSchema<'object'>;
    paramsValues: Record<string, IFlowConstantRefValue>;
    body: {
      bodyType: 'none' | 'form-data' | 'x-www-form-urlencoded' | 'raw-text' | 'JSON';
      json?: IFlowTemplateValue;
      formData?: IJsonSchema<'object'>;
      formDataValues?: Record<string, IFlowConstantRefValue>;
      rawText?: IFlowTemplateValue;
      xWwwFormUrlencoded?: IJsonSchema<'object'>;
      xWwwFormUrlencodedValues?: Record<string, IFlowConstantRefValue>;
    };
    timeout: {
      retryTimes: number;
      timeout: number;
    };
  };
}
