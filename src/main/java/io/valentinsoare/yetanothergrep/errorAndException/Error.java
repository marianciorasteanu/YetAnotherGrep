package io.valentinsoare.yetanothergrep.errorAndException;

public abstract class Error {
    private Severity severity;
    private String clazzName;
    private String methodName;
    private String threadName;

    Error() {}

    public Error getError() {
        return this;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getClazzName() {
        return clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public String toString() {
        return String.format("Severity: %s, ClazzName: %s, MethodName: %s, ThreadName: %s",
                severity, clazzName, methodName, threadName);
    }
}
