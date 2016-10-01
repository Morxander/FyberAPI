package morxander.fyberapi.helpers;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by morxander on 9/30/16.
 */

public class ApiHelper {
    private static String API_KEY = "1c915e3b5d42d05136185030892fbb846c278927";
    private static String API_BASE_URL = "http://api.fyber.com/feed/v1/";
    private static String OFFERS_PATH = "offers.json";

    public String offersUrl(){
        return API_BASE_URL + OFFERS_PATH;
    }

    public static String orderParams(String params){
        String[] paramsArray = params.split("&");
        Arrays.sort(paramsArray);
        StringBuilder paramsBuilder = new StringBuilder();
        for(String param : paramsArray) {
            paramsBuilder.append(param + "&");
        }
        return paramsBuilder.toString();
    }

    public static String generateHash(String params){
        params = params + API_KEY;
        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(params.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BigInteger(1, crypt.digest()).toString(16);
    }
}
