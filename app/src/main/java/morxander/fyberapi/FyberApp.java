package morxander.fyberapi;

import android.app.Application;
import android.content.Context;

/**
 * Created by morxander on 10/1/16.
 */

public class FyberApp extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        FyberApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return FyberApp.context;
    }

}
