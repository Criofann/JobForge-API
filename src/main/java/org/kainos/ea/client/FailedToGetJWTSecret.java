package org.kainos.ea.client;

public class FailedToGetJWTSecret extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to get JWT secret";
    }
}
