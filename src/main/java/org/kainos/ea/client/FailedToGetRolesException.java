package org.kainos.ea.client;

public class FailedToGetRolesException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to get roles from database";
    }
}