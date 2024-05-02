package com.urlShortner.demo.Entity;

import java.net.MalformedURLException;
import java.net.URL;

public class Url {
    private String key;
    private String url;
    private int count;

    public Url() {
    }

    public Url(String key, String url, int count) {
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
                "key=" + key +
                ", url='" + url + '\'' +
                ", count=" + count +
                '}';
    }

}