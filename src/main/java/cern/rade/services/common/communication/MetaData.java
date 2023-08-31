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
            return -1;
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
    public RequestAction getRequest_action() {
        String req_action = getString("req_action");
        if (req_action != null && !req_action.equals("")) {
            return RequestAction.valueOf(req_action);
        }
        else{
            return null;
        }
    }
    public RequestLanguage getRequest_language() {
        String req_lang = getString("req_lang");
        if (req_lang!=null && !req_lang.equals("")) {
            return RequestLanguage.valueOf(req_lang);
        }
        else{
            return null;
        }
    }
    public AuthenticationType getAuth_type() {
        String auth_type = getString("auth_type");
        if (auth_type != null && !auth_type.equals("")) {
            return AuthenticationType.valueOf(auth_type);
        }
        else{
            return AuthenticationType.NONE;
        }
    }

    public String getSelector() {
        return getString("selector");
    }
    public String getDevice() {
        return getString("device");
    }
    public int getRbac_id() {
        return getInt("rbac_id");
    }
    public int getSub_id() {
        return getInt("sub_id");
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
    public void setSub_id(int sub_id){
        jsonObject.add("sub_id", new JsonPrimitive(sub_id));
    }
    public void setRbac_id(int rbac_id){
        jsonObject.add("rbac_id", new JsonPrimitive(rbac_id));
    }
    public void setError(String error){
        jsonObject.add("error", new JsonPrimitive(error));
    }
    public String getReq_url(){
        return getString("req_url");
    }

    public String toString(){
        String url;
        if(getReq_url()==null){
            url = getDevice();
        }
        else{
            url= getReq_url();
        }

        return String.format("[user: %s | action: %s | language: %s | authentication: %s | url: %s | selector: %s]",
                getUsername(), getRequest_action().getName(), getRequest_language().getName(),
                getAuth_type().getName(), url, getSelector());
    }
}
