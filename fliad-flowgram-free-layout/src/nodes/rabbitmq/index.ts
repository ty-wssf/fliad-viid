/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { nanoid } from 'nanoid';

import { WorkflowNodeType } from '../constants';
import { FlowNodeRegistry } from '../../typings';
import iconRabbitmq from '../../assets/icon-rabbitmq.svg';

let index = 0;
export const RabbitmqNodeRegistry: FlowNodeRegistry = {
  type: WorkflowNodeType.Rabbitmq,
  info: {
    icon: iconRabbitmq,
    description:
      '推送数据到rabbitmq',
  },
  meta: {
    size: {
      width: 360,
      height: 390,
    },
  },
  onAdd() {
    return {
      id: `rabbitmq_${nanoid(5)}`,
      type: 'rabbitmq',
      data: {
        title: `Rabbitmq_${++index}`,
        inputsValues: {
          ip: {
            type: 'constant',
            content: '127.0.0.1',
          },
          port: {
            type: 'constant',
            content: 5672,
          },
          username: {
            type: 'constant',
            content: 'ahbcht',
          },
          password: {
            type: 'constant',
            content: 'Bcht123',
          },
          exchange: {
            type: 'constant',
            content: 'BCHT_ITS_DATA',
          },
          routingKey: {
            type: 'constant',
            content: 'test',
          },
        },
        inputs: {
          type: 'object',
          required: ['ip', 'port', 'username', 'password', 'exchange', 'routingKey'],
          properties: {
            ip: {
              type: 'string',
            },
            port: {
              type: 'number',
            },
            username: {
              type: 'string',
            },
            password: {
              type: 'string',
            },
            exchange: {
              type: 'string'
            },
            routingKey: {
              type: 'string',
            },
            msg: {
              type: 'string',
            },
          },
        },
        outputs: {

        },
      },
    };
  },
};