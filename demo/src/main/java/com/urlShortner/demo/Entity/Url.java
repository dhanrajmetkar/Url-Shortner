package com.urlShortner.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.net.MalformedURLException;
import java.net.URL;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String shorturl;
    private String url;
    private int count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Url() {
    }

    public Url(String shorturl, String url, int count) {
        this.shorturl = shorturl;
        this.url = url;
        this.count = count;
    }

    public String getUrlString() {
        return url;
    }
        public URL getUrl() {
        URL ur;
        try {
            ur = new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return ur;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Url{" +
                "shorturl='" + shorturl + '\'' +
                ", url='" + url + '\'' +
                ", count=" + count +
                '}';
    }

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }
}