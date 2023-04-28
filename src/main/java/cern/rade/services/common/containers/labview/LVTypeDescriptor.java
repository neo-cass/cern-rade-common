package cern.rade.services.common.containers.labview;

public class LVTypeDescriptor {
    private LVType lvType;
    private String name;
    public LVTypeDescriptor(LVType lvType, String name){
        this.lvType = lvType;
        this.name = name;
    }
    public LVType getType() {
        return lvType;
    }

    public String getName() {return name;}

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append(", Type: ");
        stringBuilder.append(lvType);
        stringBuilder.append(" | ");
        return stringBuilder.toString();
    }
}
