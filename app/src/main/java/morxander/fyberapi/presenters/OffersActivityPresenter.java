package morxander.fyberapi.presenters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import morxander.fyberapi.FyberApp;
import morxander.fyberapi.R;
import morxander.fyberapi.activities.OffersActivity;
import morxander.fyberapi.helpers.RequestListener;
import morxander.fyberapi.items.OfferItem;
import morxander.fyberapi.network.OffersRequest;
import nucleus.presenter.Presenter;

/**
 * Created by morxander on 10/1/16.
 */

public class OffersActivityPresenter extends Presenter<OffersActivity> {

    // [ 0 => init. 1 => requesting network, 2 => offers, 3 => no offers, 4 => network error ]
    private int status = 0;
    private List<OfferItem> offerList;

    @Override
    protected void onCreate(@Nullable Bundle savedState) {
        super.onCreate(savedState);
        offerList = new ArrayList<OfferItem>();
        OffersRequest offersRequest = new OffersRequest(FyberApp.getAppContext(), new RequestListener() {
            @Override
            public void onFinished(String body) {
                if(body == null){
                    status = 4;
                }else {
                    try {
                        // This a json string for testing
                        String jsonBody = "{'code':'OK','message':'OK','count':1,'pages':1,'information':{'app_name':'SPTestApp','appid':157,'virtual_currency':'Coins','country':'US','language':'EN','support_url':'http://iframe.fyber.com/mobile/DE/157/my_offers'},'offers':[{'title':'TapFish','offer_id':13554,'teaser':'DownloadandSTART','required_actions':'DownloadandSTART','link':'http://iframe.fyber.com/mbrowser?appid=157&lpid=11387&uid=player1','offer_types':[{'offer_type_id':101,'readable':'Download'},{'offer_type_id':112,'readable':'Free'}],'thumbnail':{'lowres':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_60.png','hires':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_175.png'},'payout':90,'time_to_payout':{'amount':1800,'readable':'30minutes'}},{'title':'TapFish2','offer_id':13554,'teaser':'DownloadandSTART','required_actions':'DownloadandSTART','link':'http://iframe.fyber.com/mbrowser?appid=157&lpid=11387&uid=player1','offer_types':[{'offer_type_id':101,'readable':'Download'},{'offer_type_id':112,'readable':'Free'}],'thumbnail':{'lowres':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_60.png','hires':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_175.png'},'payout':90,'time_to_payout':{'amount':1800,'readable':'30minutes'}},{'title':'TapFish3','offer_id':13554,'teaser':'DownloadandSTART','required_actions':'DownloadandSTART','link':'http://iframe.fyber.com/mbrowser?appid=157&lpid=11387&uid=player1','offer_types':[{'offer_type_id':101,'readable':'Download'},{'offer_type_id':112,'readable':'Free'}],'thumbnail':{'lowres':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_60.png','hires':'http://cdn.fyber.com/assets/1808/icon175x175-2_square_175.png'},'payout':90,'time_to_payout':{'amount':1800,'readable':'30minutes'}}]}";
                        JSONObject responseJson = new JSONObject(body);
                        if (responseJson.getInt("count") == 0) {
                            status = 3;
                        } else {
                            status = 2;
                        }
                        JSONArray offersArray = responseJson.getJSONArray("offers");
                        for (int i = 0; i < offersArray.length(); i++) {
                            JSONObject offer = offersArray.getJSONObject(i);
                            JSONObject thumb = offer.getJSONObject("thumbnail");
                            OfferItem offerItem = new OfferItem(offer.getString("title"), offer.getString("teaser"), thumb.getString("hires"), offer.getInt("payout"));
                            offerList.add(offerItem);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                updateView();
            }
        });
        offersRequest.execute();
        status = 1;

    }

    @Override
    protected void onTakeView(OffersActivity offersActivity) {
        super.onTakeView(offersActivity);
        updateView();
    }

    private void updateView() {
        if(status == 0){
            if(getView() != null) {

            }
        }else if(status == 1){
            if(getView() != null) {
                getView().showDialog();
            }
        }else if(status == 4){
            if(getView() != null){
                getView().empty_text.setText(getView().getString(R.string.network_error));
                getView().empty_view.setVisibility(View.VISIBLE);
                getView().hideDialog();
            }
        }else if(status == 3){
            if(getView() != null) {
                getView().empty_text.setText(getView().getString(R.string.no_offers));
                getView().empty_view.setVisibility(View.VISIBLE);
                getView().hideDialog();
            }
        }else if(status == 2){
            if(getView() != null) {
                getView().empty_view.setVisibility(View.GONE);
                getView().updateView(offerList);
                getView().hideDialog();
            }
        }
    }

    @Override
    protected void onDropView() {
        super.onDropView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
