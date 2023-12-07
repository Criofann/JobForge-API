package org.kainos.ea.client;

public class FailedToCreateJobFamilyException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to create job";
    }
}

