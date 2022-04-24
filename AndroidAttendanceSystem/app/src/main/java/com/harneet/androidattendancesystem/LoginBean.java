package com.harneet.androidattendancesystem;

/**
 * Created by Windows-10 on 9/13/2018.
 */

public class LoginBean {

    private String status;
    private String utype;
    private String name;

   /* LoginBean(String x,String y,String z)
    {
         this.status=x;
        this.utype=y;
        this.name=z;
    }*/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
