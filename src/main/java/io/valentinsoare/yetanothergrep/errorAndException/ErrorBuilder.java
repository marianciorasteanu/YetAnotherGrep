package io.valentinsoare.yetanothergrep.errorAndException;

public class ErrorBuilder {
    private final ErrorMessage errorMessage;

    public ErrorBuilder() {
        this.errorMessage = new ErrorMessage();
    }

    public ErrorBuilder withSeverity(Severity severity) {
        this.errorMessage.getError().setSeverity(severity);
        return this;
    }

    public ErrorBuilder withClazzName(String clazzName) {
        this.errorMessage.getError().setClazzName(clazzName);
        return this;
    }

    public ErrorBuilder withMethodName(String methodName) {
        this.errorMessage.getError().setMethodName(methodName);
        return this;
    }

    public ErrorBuilder withThreadName(String threadName) {
        this.errorMessage.getError().setThreadName(threadName);
        return this;
    }

    public ErrorBuilder withMessage(String message) {
        this.errorMessage.setMessage(message);
        return this;
    }

    public ErrorBuilder withDateTime(String dateTime) {
        this.errorMessage.setDateTime(dateTime);
        return this;
    }

    public ErrorMessage build() {
        return this.errorMessage;
    }

    public static ErrorBuilder getBuilder() {
        return new ErrorBuilder();
    }
}
