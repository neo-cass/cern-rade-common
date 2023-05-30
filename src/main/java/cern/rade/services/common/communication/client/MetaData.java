package cern.rade.services.common.communication.client;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class MetaData {
    private JsonObject jsonObject;

    public MetaData (JsonObject jsonObject){
        this.jsonObject = jsonObject;
    }

    public MetaData (){
        this.jsonObject = new JsonObject();
    }

    public String getUsername() {
        return jsonObject.get("username").getAsString();
    }

    public String getPassword() {
        return jsonObject.get("password").getAsString();
    }

    public String getRequest_action() {
        return jsonObject.get("request_action").getAsString();
    }

    public String getRequest_language() {
        return jsonObject.get("request_language").getAsString();
    }

    public String getSelector() {
        return jsonObject.get("selector").getAsString();
    }

    public String getDevice() {
        return jsonObject.get("device").getAsString();
    }

    public String getProperty() {
        return jsonObject.get("property").getAsString();
    }

    public int getRbac_id() {
        return jsonObject.get("rbac_id").getAsInt();
    }
    public String getAuth_type() {
        return jsonObject.get("auth_type").getAsString();
    }
    public String flatten(){
        Gson gson = new Gson();
        return gson.toJson(jsonObject);
    }

    public short[] getType_descriptor() {
        JsonArray arr = jsonObject.getAsJsonArray("type_descriptor");
        short[] type_descriptor = new short[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            type_descriptor[i] = arr.get(i).getAsShort();
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
