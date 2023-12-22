package org.kainos.ea.client;

public class InvalidRoleException extends Throwable {
    @Override
    public String getMessage() {
        return "The role entered is not a valid role.\n"
                 + " Please enter a valid role";
    }
}
