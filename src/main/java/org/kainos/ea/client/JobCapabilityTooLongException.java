package org.kainos.ea.client;

public class JobCapabilityTooLongException extends Throwable {
    @Override
    public String getMessage(){
        return "capability is too long";
    }
}
