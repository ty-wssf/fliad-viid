package com.fliad.viid.modular.flowgram.domain;

public class TaskValidateOutput {

    /**
     * 表示验证是否通过，true 表示验证成功，false 表示验证失败
     */
    private boolean valid;
    /**
     * 可选字段，当验证失败时包含具体的错误信息列表
     */
    private String[] errors;

    public TaskValidateOutput(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
