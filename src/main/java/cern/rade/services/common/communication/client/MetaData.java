package cern.rade.services.common.communication.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MetaData {
    private JsonObject jsonObject;

    public MetaData (JsonObject jsonObject){
        this.jsonObject = jsonObject;
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

    public short[] getType_descriptor() {
        JsonArray arr = jsonObject.get("type_descriptor").getAsJsonArray();
        short[] type_descriptor = new short[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            type_descriptor[i] = arr.get(i).getAsShort();
        }
        return type_descriptor;
    }
}
