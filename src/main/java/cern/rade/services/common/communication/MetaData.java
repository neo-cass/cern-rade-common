package cern.rade.services.common.communication;

import com.google.gson.*;

public class MetaData {
    private JsonObject jsonObject;

    public MetaData (JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public MetaData (){
        this.jsonObject = new JsonObject();
    }

    private String getString(String name){
        JsonElement element = jsonObject.get(name);
        if (element==null){
            return null;
        }
        else{
            return element.getAsString();
        }
    }

    private int getInt(String name){
        JsonElement element = jsonObject.get(name);
        if (element==null){
            return 0;
        }
        else{
            return element.getAsInt();
        }
    }

    public String getUsername() {
        return getString("username");
    }
    public String getPassword() {
        return getString("password");
    }
    public String getRequest_action() {
        return getString("req_action");
    }
    public String getRequest_language() {
        return getString("req_lang");
    }
    public String getSelector() {
        return getString("selector");
    }
    public String getDevice() {
        return getString("device");
    }
    public String getProperty() {
        return getString("property");
    }
    public int getRbac_id() {
        return getInt("rbac_id");
    }
    public int getSub_id() {
        return getInt("sub_id");
    }
    public String getAuth_type() {
        return getString("auth_type");
    }

    public String flatten(){
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }

    public short[] getType_descriptor() {
        JsonArray arr = jsonObject.getAsJsonArray("type_descriptor");
        if (arr == null){
            return null;
        }
        short[] type_descriptor = new short[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            type_descriptor[i] = arr.get(i).getAsShort();
        }
        return type_descriptor;
    }
    public byte[] getRbac_token() {
        JsonArray arr = jsonObject.getAsJsonArray("rbac_token");
        if (arr == null){
            return null;
        }
        byte[] type_descriptor = new byte[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            type_descriptor[i] = arr.get(i).getAsByte();
        }
        return type_descriptor;
    }


    public void setType_descriptor(short [] type_descriptor) {
        JsonArray arr = new JsonArray();
        for (int i = 0; i < type_descriptor.length; i++){
            arr.add(type_descriptor[i]);
        }
       jsonObject.add("type_descriptor", arr);
    }

    public void setAcq_stamp(long acq_stamp){
        jsonObject.add("acq_stamp", new JsonPrimitive(acq_stamp));
    }

    public void setRbac_id(int rbac_id){
        jsonObject.add("rbac_id", new JsonPrimitive(rbac_id));
    }

}
