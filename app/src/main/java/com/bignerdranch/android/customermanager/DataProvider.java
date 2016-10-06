package com.bignerdranch.android.customermanager;

/**
 * Created by jamila on 9/28/2016.
 */

public class DataProvider {

    private String  first;
    private String last;
    private String session;

    public DataProvider(String first, String last, String session){
        this.first = first;
        this.last = last;
        this.session = session;
    }

    public DataProvider(String first, String last){
        this.first = first;
        this.last = last;

    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getSession() {
        return session;
    }
}
