package cern.rade.services.common.communication.client;

public enum RequestAction {
    GET("GET"),
    GET_SECURE("GET_SECURE"),
    SET("SET"),
    SET_SECURE("SET_SECURE"),
    SUBSCRIBE("SUBSCRIBE");
    private String name;
    RequestAction(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
