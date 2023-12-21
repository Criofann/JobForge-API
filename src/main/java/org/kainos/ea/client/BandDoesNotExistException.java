package org.kainos.ea.client;

public class BandDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return
                "Band selected does not exist";
    }
}
