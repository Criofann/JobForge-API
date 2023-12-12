package org.kainos.ea.client;

public class JobBandTooLongException extends Throwable {
    @Override
    public String getMessage(){
        return "Band name is too long";
    }
}
