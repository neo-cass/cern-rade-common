package cern.rade.services.common.communication;

public enum AuthenticationType {
    RBAC_EXPLICIT("RBAC_EXPLICIT"),
    NONE("NONE"),
    RBAC_CACHED("RBAC_CACHED"),
    RBAC_LOCATION("RBAC_LOCATION");
    private String name;
    AuthenticationType(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
