package com.optiimtest.noteservice.model;

/**
 * Created By: Bekir Tezcan
 * Created At: 3.03.2020
 * Description :
 */
public class Email {
    private String mailId;

    private String fromAddress;

    private String toAddress;

    private String subject;

    private String content;

    public String getMailId() {
        return mailId;
    }

    public Email setMailId(String mailId) {
        this.mailId = mailId;
        return this;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public Email setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
        return this;
    }

    public String getToAddress() {
        return toAddress;
    }

    public Email setToAddress(String toAddress) {
        this.toAddress = toAddress;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Email setContent(String content) {
        this.content = content;
        return this;
    }
}