package morxander.fyberapi.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import morxander.fyberapi.R;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;
import presenters.MainActivityPresenter;

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
    void fillData(){
        editTextUid.setText("spiderman");
        editTextApiKey.setText("1c915e3b5d42d05136185030892fbb846c278927");
        editTextAppId.setText("2070");
        editTextPub.setText("campaign2");
    }
}
