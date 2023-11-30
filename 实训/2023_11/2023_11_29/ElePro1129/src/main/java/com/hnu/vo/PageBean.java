package com.hnu.vo;

import java.util.List;

public class PageBean<T>{

    /*
    总记录
    总页数
    数据
     */
    private Integer totalRows;
    private Integer totalPages;
    private List<T> data;

    public PageBean() {
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    /*
    总记录 / 每页显示的记录数
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}