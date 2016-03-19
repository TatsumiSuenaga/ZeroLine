package com.cse.team12.zeroline;

/**
 * Created by ftwpk on 3/16/2016.
 * Model for places
 */
public class Places {
    private long mId;
    private String mName;
    private String mPhone;
    private String mAddress;
    private String mPlace_type;


    public Places () {
        mId = -1;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPlace_type() {
        return mPlace_type;
    }

    public void setPlace_type(String place_type) {
        mPlace_type = place_type;
    }
}
