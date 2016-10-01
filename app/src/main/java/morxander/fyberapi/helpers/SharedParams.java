package morxander.fyberapi.helpers;

/**
 * Created by morxander on 10/1/16.
 */
public class SharedParams {

    private static SharedParams ourInstance = new SharedParams();
    private String uid;
    private String api_key;
    private String app_id;
    private String pub;
    private String device_id;

    public static SharedParams getInstance() {
        return ourInstance;
    }

    private SharedParams() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
