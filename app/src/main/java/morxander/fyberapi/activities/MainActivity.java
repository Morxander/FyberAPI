package morxander.fyberapi.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import morxander.fyberapi.R;
import morxander.fyberapi.helpers.SharedParams;
import morxander.fyberapi.presenters.MainActivityPresenter;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;

@RequiresPresenter(MainActivityPresenter.class)
public class MainActivity extends NucleusAppCompatActivity<MainActivityPresenter> {

    @BindView(R.id.edittext_uid)
    EditText editTextUid;

    @BindView(R.id.edittext_api_key)
    EditText editTextApiKey;

    @BindView(R.id.edittext_app_id)
    EditText editTextAppId;

    @BindView(R.id.edittext_pub)
    EditText editTextPub;

    @BindView(R.id.button_submit)
    Button buttonSubmit;

    @BindView(R.id.button_fill_data)
    Button buttonFillData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_fill_data)
    void fillData() {
        editTextUid.setText("spiderman");
        editTextApiKey.setText("1c915e3b5d42d05136185030892fbb846c278927");
        editTextAppId.setText("2070");
        editTextPub.setText("campaign2");
    }

    @OnClick(R.id.button_submit)
    void submit() {
        TelephonyManager mngr;
        String deviceId;
        // Trying to get the device ID
        try{
            mngr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = mngr.getDeviceId();
        }catch (SecurityException exp){
            deviceId = "000000000";
        }
        // Singleton object to share the params with the AsyncTask
        SharedParams sharedParams = SharedParams.getInstance();
        sharedParams.setUid(editTextUid.getText().toString());
        sharedParams.setApi_key(editTextApiKey.getText().toString());
        sharedParams.setApp_id(editTextAppId.getText().toString());
        sharedParams.setPub(editTextPub.getText().toString());
        sharedParams.setDevice_id(deviceId);
        startActivity(new Intent(this, OffersActivity.class));
    }
}
