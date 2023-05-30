package cern.rade.services.common.communication;

public enum RequestLanguage {
    LABVIEW("LABVIEW"),
    PYTHON("PYTHON");
    private String name;
    RequestLanguage(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
