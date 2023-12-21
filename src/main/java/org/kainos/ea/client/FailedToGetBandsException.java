package org.kainos.ea.client;

public class FailedToGetBandsException extends Throwable {
    @Override
    public String getMessage() {
        return
                "Failed to get Bands from database";
    }
}
