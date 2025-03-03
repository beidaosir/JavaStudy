package com.beidao.module6.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 视频
 */
public class Video {

    private String bv; // 视频id
    private String title; // 视频标题
    private LocalDateTime publishTime; // 视频发布时间
    private String cover; // 视频封面
    private String introduction; // 视频简介
    private List<String> tagList; // 视频标签


    private List<Play> playList; // 视频播放列表

    private String type; // 视频类型

    private String category; // 视频分类


    public Video() {
    }

    public Video(String bv, String title, LocalDateTime publishTime, String cover, String introduction, List<String> tagList, List<Play> playList, String type, String category) {
        this.bv = bv;
        this.title = title;
        this.publishTime = publishTime;
        this.cover = cover;
        this.introduction = introduction;
        this.tagList = tagList;
        this.playList = playList;
        this.type = type;
        this.category = category;
    }

    /**
     * 获取
     * @return bv
     */
    public String getBv() {
        return bv;
    }

    /**
     * 设置
     * @param bv
     */
    public void setBv(String bv) {
        this.bv = bv;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return publishTime
     */
    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    /**
     * 设置
     * @param publishTime
     */
    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 获取
     * @return cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置
     * @param cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取
     * @return tagList
     */
    public List<String> getTagList() {
        return tagList;
    }

    /**
     * 设置
     * @param tagList
     */
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    /**
     * 获取
     * @return playList
     */
    public List<Play> getPlayList() {
        return playList;
    }

    /**
     * 设置
     * @param playList
     */
    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "Video{bv = " + bv + ", title = " + title + ", publishTime = " + publishTime + ", cover = " + cover + ", introduction = " + introduction + ", tagList = " + tagList + ", playList = " + playList + ", type = " + type + ", category = " + category + "}";
    }
}
