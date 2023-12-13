package org.kainos.ea.client;

public class FailedToUpdateRoleException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to update the role. Please try again";
    }
}
