package morxander.fyberapi.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import morxander.fyberapi.helpers.ApiHelper;
import morxander.fyberapi.helpers.RequestListener;
import morxander.fyberapi.helpers.SharedParams;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by morxander on 10/1/16.
 */

public class OffersRequest extends AsyncTask{

    private RequestListener callBack;
    private Context context;

    public OffersRequest(Context context, RequestListener callback) {
        this.callBack = callback;
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        SharedParams sharedParams = SharedParams.getInstance();
        String timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + "";
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(ApiHelper.offersUrl()).newBuilder();
        urlBuilder.addQueryParameter("appid", sharedParams.getApp_id());
        urlBuilder.addQueryParameter("device_id", sharedParams.getDevice_id());
        urlBuilder.addQueryParameter("ip", "109.235.143.113");
        urlBuilder.addQueryParameter("locale", "de");
        urlBuilder.addQueryParameter("offer_types", "112");
        urlBuilder.addQueryParameter("timestamp", timeStamp);
        urlBuilder.addQueryParameter("uid", sharedParams.getUid());
        urlBuilder.addQueryParameter("hashkey", ApiHelper.generateHash(ApiHelper.orderParams(urlBuilder.build().toString().split("\\?")[1])));

        String url = urlBuilder.build().toString();
        Log.v("url",url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response body = (Response) o;
        try {
            if (callBack != null && body != null) {
                callBack.onFinished(String.valueOf(body.body().string()));
            }else {
                callBack.onFinished(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
