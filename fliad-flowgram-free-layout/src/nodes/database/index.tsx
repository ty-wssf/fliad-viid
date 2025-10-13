/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { nanoid } from 'nanoid';

import { WorkflowNodeType } from '../constants';
import { FlowNodeRegistry } from '../../typings';
import iconDatabase from '../../assets/icon-database.svg';
import { formMeta } from './form-meta';

let index = 0;

export const DatabaseNodeRegistry: FlowNodeRegistry = {
  type: WorkflowNodeType.Database,
  info: {
    icon: iconDatabase,
    description: '数据库写入',
  },
  meta: {
    size: {
      width: 360,
      height: 420,
    },
  },
  onAdd() {
    return {
      id: `database_${nanoid(5)}`,
      type: WorkflowNodeType.Database,
      data: {
        title: `数据库_${++index}`,
        connection: {
          type: 'mysql',
          port: 3306,
        },
        query: {
          queryType: 'params',
          table: ''
        },
        fields: {},
        outputs: {
          type: 'object',
          properties: {
            rowCount: { type: 'integer', description: '影响的行数' },
            success: { type: 'boolean', description: '写入是否成功' }
          },
        },
      },
    };
  },
  formMeta: formMeta,
};
