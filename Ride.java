import java.util.*;

public class Ride {
    private Date mRideStart, mRideEnd;
    private Basket mItems;

    public Ride(Date rideStart, Date rideEnd, Basket items) {
        mRideStart = rideStart;
        mRideEnd = rideEnd;
        mItems = items;
    }

    public void setRideStart(Date rideStart) {
        mRideStart = rideStart;
    }

    public void setRideEnd(Date rideEnd) {
        mRideEnd = rideEnd;
    }

    public void setBasket(Basket items) {
        mItems = items;
    }

    public Date getRideStart() {
        return mRideStart;
    }

    public Date getRideEnd() {
        return mRideEnd;
    }

    public Basket getBasket() {
        return mItems;
    }
}
