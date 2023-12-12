package org.kainos.ea.client;

public class NotURLException extends Throwable {
    @Override
    public String getMessage(){
        return "not a valid url";
    }
}
