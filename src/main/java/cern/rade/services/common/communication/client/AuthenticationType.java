package cern.rade.services.common.communication.client;

public enum AuthenticationType {
    SECURE("SECURE"),
    NORMAL("NORMAL"),
    SECURE_BY_LOCATION("SECURE_BY_LOCATION");
    private String name;
    AuthenticationType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
