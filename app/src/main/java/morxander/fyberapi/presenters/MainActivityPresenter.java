package morxander.fyberapi.presenters;

import android.os.Bundle;
import android.support.annotation.Nullable;

import morxander.fyberapi.activities.MainActivity;
import nucleus.presenter.Presenter;

/**
 * Created by morxander on 9/30/16.
 */

public class MainActivityPresenter extends Presenter<MainActivity> {

    @Override
    protected void onCreate(@Nullable Bundle savedState) {
        super.onCreate(savedState);
    }

    @Override
    protected void onTakeView(MainActivity mainActivity) {
        super.onTakeView(mainActivity);
    }

    @Override
    protected void onDropView() {
        super.onDropView();
    }
}
