/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { Field } from '@flowgram.ai/free-layout-editor';
import { CodeEditor } from '@flowgram.ai/form-materials';
import { Divider } from '@douyinfe/semi-ui';

import { useIsSidebar, useNodeRenderContext } from '../../../hooks';

// Map our supported languages to the editor's language identifiers
const languageMap = {
  javascript: 'javascript',
  xlang: 'xlang',
};

export function Code() {
  const isSidebar = useIsSidebar();
  const { readonly } = useNodeRenderContext();

  if (!isSidebar) {
    return null;
  }

  return (
    <>
      <Divider />
      <Field<string> name="script.content">
        {({ field: contentField }) => (
          <Field<string> name="script.language">
            {({ field: languageField }) => {
              const languageId = languageMap[languageField.value as keyof typeof languageMap] || 'javascript';

              return (
                <CodeEditor
                  languageId={languageId}
                  value={contentField.value}
                  onChange={(value) => contentField.onChange(value)}
                  readonly={readonly}
                />
              );
            }}
          </Field>
        )}
      </Field>
    </>
  );
}
