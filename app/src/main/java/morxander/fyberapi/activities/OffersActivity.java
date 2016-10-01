package morxander.fyberapi.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import morxander.fyberapi.R;
import morxander.fyberapi.adapters.OffersAdapter;
import morxander.fyberapi.items.OfferItem;
import morxander.fyberapi.presenters.OffersActivityPresenter;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;

@RequiresPresenter(OffersActivityPresenter.class)
public class OffersActivity extends NucleusAppCompatActivity<OffersActivityPresenter> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.empty_view)
    public LinearLayout empty_view;

    @BindView(R.id.empty_text)
    public TextView empty_text;

    @BindView(R.id.list_offers)
    RecyclerView offersRecyclerView;

    private ProgressDialog dialog;
    private OffersAdapter offersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.loading));
    }

    public void showDialog() {
        dialog.show();
    }

    public void hideDialog() {
        dialog.dismiss();
    }

    public void updateView(List<OfferItem> offerItemList){
        offersRecyclerView.setHasFixedSize(false);
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        offersAdapter = new OffersAdapter(offerItemList, this);
        offersRecyclerView.setAdapter(offersAdapter);
    }

}
