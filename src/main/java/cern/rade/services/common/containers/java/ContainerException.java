package cern.rade.services.common.containers.java;

import java.io.IOException;

public class ContainerException extends Exception {
    public ContainerException(String message, Throwable error){
        super(message, error);
    }
    public ContainerException(String message){
        super(message);
    }
}
