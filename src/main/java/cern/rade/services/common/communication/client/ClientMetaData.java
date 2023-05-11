package cern.rade.services.common.communication.client;

import com.google.gson.JsonObject;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.toArray;

public class ClientMetaData {
    private String username;
    private String password;
    private String request_action;
    private String request_language;
    private String selector;
    private String device;
    private String property;
    private short[] type_descriptor;
    public ClientMetaData(String username,
                          String password,
                          String request_action,
                          String request_language,
                          String selector,
                          String device,
                          String property,
                          short[] type_descriptor)
    {
        this.username=username;
        this.password=password;
        this.request_action = request_action;
        this.request_language = request_language;
        this.selector=selector;
        this.device=device;
        this.property=property;
        this.type_descriptor = type_descriptor;
    }

//    public ClientMetaData(JsonObject jsonObject)
//    {
//        this.username= jsonObject.get("username").getAsString();
//        this.password=jsonObject.get("password").getAsString();
//        this.request_action = jsonObject.get("request_action").getAsString();
//        this.request_language = jsonObject.get("request_language").getAsString();
//        this.selector=jsonObject.get("selector").getAsString();
//        this.device=jsonObject.get("device").getAsString();
//        this.property=jsonObject.get("property").getAsString();
//
//        this.type_descriptor = ArrayUtils.toPrimitive(((List<Short>)(List<?>)jsonObject.getAsJsonArray("type_descriptor").asList()).toArray(new Short[0]));
//    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("username: ");
        stringBuilder.append(username);
        stringBuilder.append("\n");

        stringBuilder.append("request action: ");
        stringBuilder.append(request_action);
        stringBuilder.append("\n");

        stringBuilder.append("request language: ");
        stringBuilder.append(request_language);
        stringBuilder.append("\n");

        stringBuilder.append("selector: ");
        stringBuilder.append(selector);
        stringBuilder.append("\n");

        stringBuilder.append("device: ");
        stringBuilder.append(device);
        stringBuilder.append("\n");

        stringBuilder.append("property: ");
        stringBuilder.append(property);
        stringBuilder.append("\n");

        stringBuilder.append("type descriptor: ");
        stringBuilder.append(Arrays.toString(type_descriptor));
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRequest_action() {
        return request_action;
    }

    public String getRequest_language() {
        return request_language;
    }

    public String getSelector() {
        return selector;
    }

    public String getDevice() {
        return device;
    }

    public String getProperty() {
        return property;
    }

    public short[] getType_descriptor() {
        return type_descriptor;
    }
}
