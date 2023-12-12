package org.kainos.ea.client;

public class JobFamilyTooLongException extends Throwable {
    @Override
    public String getMessage(){
        return "Job Family is too long";
    }
}
