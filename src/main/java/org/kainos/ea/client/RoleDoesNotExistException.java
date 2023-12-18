package org.kainos.ea.client;

public class RoleDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return "The Role entered does not exist";
    }
}
