package morxander.fyberapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import morxander.fyberapi.R;
import morxander.fyberapi.items.OfferItem;

/**
 * Created by morxander on 10/1/16.
 */

public class OffersViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.offer_thumb)
    ImageView offer_thumb;

    @BindView(R.id.offer_title)
    TextView offer_title;

    @BindView(R.id.offer_teaser)
    TextView offer_teaser;

    @BindView(R.id.offer_payout)
    TextView offer_payout;

    public OffersViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(Context context, OfferItem offerItem) {
        offer_title.setText(offerItem.getTitle());
        offer_teaser.setText(offerItem.getTeaser());
        offer_payout.setText(String.valueOf(offerItem.getPayout()));
        Picasso.with(context).load(offerItem.getThumb()).resize(150, 150).centerCrop().into(offer_thumb);
    }
}
