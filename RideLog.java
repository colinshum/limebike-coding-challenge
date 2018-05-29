import java.util.*;

public class RideLog {
    private Basket mItems;
    private Date mTimeInterval;
    private boolean mKeepItems;

    public RideLog(Basket items, Date timeInterval, boolean keepItems) {
        mItems = items;
        mTimeInterval = timeInterval;
        mKeepItems = keepItems;
    }

    public void setBasket(Basket items) {
        mItems = items;
    }

    public void setTimeInterval(Date timeInterval) {
        mTimeInterval = timeInterval;
    }

    public void setKeepItems(boolean keepItems) {
        mKeepItems = keepItems;
    }

    public Basket getBasket() {
        return mItems;
    }

    public Date getTimeInterval() {
        return mTimeInterval;
    }

    public boolean getKeepItems() {
        return mKeepItems;
    }
}