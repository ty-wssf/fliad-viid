/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { useControlTips } from './use-control';
import { GroupTipsStyle } from './style';
import { isMacOS } from './is-mac-os';
import { IconClose } from './icon-close';

export const GroupTips = () => {
  const { visible, close, closeForever } = useControlTips();

  if (!visible) {
    return null;
  }

  return (
    <GroupTipsStyle className={'workflow-group-tips'}>
      <div className="container">
        <div className="content">
          <p className="text">{`Hold ${isMacOS ? 'Cmd ⌘' : 'Ctrl'} to drag node out`}</p>
          <div
            className="space"
            style={{
              width: 0,
            }}
          />
        </div>
        <div className="actions">
          <p className="close-forever" onClick={closeForever}>
            Never Remind
          </p>
          <div className="close" onClick={close}>
            <IconClose />
          </div>
        </div>
      </div>
    </GroupTipsStyle>
  );
};
