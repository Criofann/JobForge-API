package org.kainos.ea.client;

public class JobNameTooLongException extends Throwable {
    @Override
    public String getMessage(){
        return "name is too long";
    }
}

