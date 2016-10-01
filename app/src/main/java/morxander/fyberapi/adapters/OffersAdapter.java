package morxander.fyberapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import morxander.fyberapi.R;
import morxander.fyberapi.items.OfferItem;

/**
 * Created by morxander on 10/1/16.
 */

public class OffersAdapter extends RecyclerView.Adapter<OffersViewHolder> {

    private final List<OfferItem> offerItemList;
    private final LayoutInflater inflater;

    public OffersAdapter(List<OfferItem> offerItemList, Context context) {
        this.offerItemList = offerItemList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public OffersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.offer_row_list, parent, false);
        return new OffersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OffersViewHolder holder, int position) {
        holder.bindView(inflater.getContext(), offerItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return offerItemList == null ? 0 : offerItemList.size();
    }
}
