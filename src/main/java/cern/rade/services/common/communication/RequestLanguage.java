package cern.rade.services.common.communication;

public enum RequestLanguage {
    LABVIEW("LABVIEW"),
    PYTHON("PYTHON"),
    COMMAND_LINE("COMMAND_LINE");
    private String name;
    RequestLanguage(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
