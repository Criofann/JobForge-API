package org.kainos.ea.client;

public class ResponsibilityTooLongException extends Throwable {
    @Override
    public String getMessage() {
        return "Responsibility is too long";
    }
}
