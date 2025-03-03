package com.beidao.module6.dto;


import java.time.LocalTime;

/**
 * 视频中的每一集
 */
public class Play {

    private String id; // 集id
    private String title; // 集标题
    private LocalTime duration; // 集时长
    private String url; // 集地址

    public Play(String id, String title, LocalTime duration, String url) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
