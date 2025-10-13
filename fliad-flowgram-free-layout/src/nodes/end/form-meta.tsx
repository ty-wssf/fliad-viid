/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import { Field, FormMeta } from '@flowgram.ai/free-layout-editor';
import {
  createInferInputsPlugin,
  DisplayInputsValues,
  IFlowValue,
  InputsValues,
} from '@flowgram.ai/form-materials';

import { defaultFormMeta } from '../default-form-meta';
import { useIsSidebar } from '../../hooks';
import { FormHeader, FormContent } from '../../form-components';

export const renderForm = () => {
  const isSidebar = useIsSidebar();
  if (isSidebar) {
    return (
      <>
        <FormHeader />
        <FormContent>
          <Field<Record<string, IFlowValue | undefined> | undefined> name="inputsValues">
            {({ field: { value, onChange } }) => (
              <>
                <InputsValues value={value} onChange={(_v) => onChange(_v)} />
              </>
            )}
          </Field>
        </FormContent>
      </>
    );
  }
  return (
    <>
      <FormHeader />
      <FormContent>
        <Field<Record<string, IFlowValue | undefined> | undefined> name="inputsValues">
          {({ field: { value } }) => (
            <>
              <DisplayInputsValues value={value} />
            </>
          )}
        </Field>
      </FormContent>
    </>
  );
};

export const formMeta: FormMeta = {
  ...defaultFormMeta,
  render: renderForm,
  plugins: [
    createInferInputsPlugin({
      sourceKey: 'inputsValues',
      targetKey: 'inputs',
    }),
  ],
};
