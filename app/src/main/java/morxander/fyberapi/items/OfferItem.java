package morxander.fyberapi.items;

/**
 * Created by morxander on 10/1/16.
 */

public class OfferItem {

    private String title;
    private String teaser;
    private String thumb;
    private int payout;

    public OfferItem() {
    }

    public OfferItem(String title, String teaser, String thumb, int payout) {
        this.title = title;
        this.teaser = teaser;
        this.thumb = thumb;
        this.payout = payout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getPayout() {
        return payout;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }
}
