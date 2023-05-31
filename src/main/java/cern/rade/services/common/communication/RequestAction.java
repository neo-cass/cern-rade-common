package cern.rade.services.common.communication;

public enum RequestAction {
    GET("GET"),
    SET("SET"),
    CACHE_RBAC("CACHE_RBAC"),
    CLEAR_RBAC("CLEAR_RBAC"),
    END_SUBSCRIBE("END_SUBSCRIBE"),
    SUBSCRIBE("SUBSCRIBE");
    private String name;
    RequestAction(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
