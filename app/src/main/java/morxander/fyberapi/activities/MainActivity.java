package morxander.fyberapi.activities;

import android.os.Bundle;

import morxander.fyberapi.R;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;
import presenters.MainActivityPresenter;

@RequiresPresenter(MainActivityPresenter.class)
public class MainActivity extends NucleusAppCompatActivity<MainActivityPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
