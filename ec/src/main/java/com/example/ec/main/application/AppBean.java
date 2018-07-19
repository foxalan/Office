package com.example.ec.main.application;

/**
 * @author alan
 *         Date  2018/7/19.
 *         Function :
 *         Issue :
 */

public class AppBean {

    private int id;
    private int imgId;
    private String text;

    public AppBean(int id, int imgId, String text) {
        this.id = id;
        this.imgId = imgId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
