package com.optiimtest.noteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
public class User {
    private String userId;

    private String name;

    private String mailAddress;

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public User setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
        return this;
    }
}
