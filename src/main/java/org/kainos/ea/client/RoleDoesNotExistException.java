package org.kainos.ea.client;

public class RoleDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return "Role does not exist";
    }
}
