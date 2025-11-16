/**
 * Copyright (c) 2025 Bytedance Ltd. and/or its affiliates
 * SPDX-License-Identifier: MIT
 */

import {Field} from '@flowgram.ai/free-layout-editor';
import {Select} from '@douyinfe/semi-ui';
import {FormItem} from '../../../form-components';

export function LanguageSelector() {
    const options = [
        {value: 'javascript', label: 'JavaScript'},
        {value: 'xlang', label: 'XLang'}
    ];

    return (
        <FormItem name="脚本语言" type="string">
            <Field<string> name="script.language">
                {({field}) => (
                    <Select
                        optionList={options}
                        value={field.value}
                        style={{width: '100%', marginBottom: 10}}
                        size="small"
                        onChange={(value) => field.onChange(value as string)}
                    />
                )}
            </Field>
        </FormItem>
    );
}
