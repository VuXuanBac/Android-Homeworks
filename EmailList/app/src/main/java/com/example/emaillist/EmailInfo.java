package com.example.emaillist;

import java.util.Date;

public class EmailInfo {

    public EmailInfo(String sender, String title, String content, Date send_date, boolean is_star) {
        this.sender = sender;
        this.title = title;
        this.content = content;
        this.send_date = send_date;
        this.is_star = is_star;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return send_date;
    }

    public void setSendDate(Date send_date) {
        this.send_date = send_date;
    }

    public boolean isStar() {
        return is_star;
    }

    public void setIsStar(boolean is_star) {
        this.is_star = is_star;
    }

    private String sender;
    private String title;
    private String content;
    private Date send_date;
    private boolean is_star;
}
