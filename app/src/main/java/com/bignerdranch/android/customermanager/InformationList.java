package com.bignerdranch.android.customermanager;

/**
 * Created by jamila on 9/26/2016.
 */

public class InformationList {

    private String fname;
    private String lname;
    private String session;

    public InformationList(String fname, String lname, String session) {
        this.fname = fname;
        this.lname = lname;
        this.session = session;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getSession() {
        return session;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
