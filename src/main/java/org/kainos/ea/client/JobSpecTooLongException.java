package org.kainos.ea.client;

public class JobSpecTooLongException extends Throwable {
    @Override
    public String getMessage(){
        return "spec is too long";
    }
}

