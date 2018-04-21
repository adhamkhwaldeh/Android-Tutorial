package com.son.jawad.ui_widgets.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adhamkh on 2017-09-07.
 */

public class Client extends Response {

    @SerializedName("ClientId")
    @Expose
    public String Id;
    @SerializedName("fullname")
    @Expose
    public String Fullname;
    @SerializedName("email")
    @Expose
    public String Email;
    @SerializedName("phone")
    @Expose
    public String Phone;
    @SerializedName("ClientState")
    @Expose
    public String Status;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
