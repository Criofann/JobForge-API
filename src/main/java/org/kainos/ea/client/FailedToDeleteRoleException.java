package org.kainos.ea.client;

public class FailedToDeleteRoleException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to delete role";
    }
}
