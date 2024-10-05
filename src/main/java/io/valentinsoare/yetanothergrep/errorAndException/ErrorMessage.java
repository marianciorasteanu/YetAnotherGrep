package io.valentinsoare.yetanothergrep.errorAndException;

public class ErrorMessage extends Error {
    private String message;
    private String dateTime;

    public ErrorMessage() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Error getError() {
        return super.getError();
    }

    @Override
    public String toString() {
        return String.format("%s, dateTime: %s, message: %s", super.toString(), dateTime, message);
    }
}
