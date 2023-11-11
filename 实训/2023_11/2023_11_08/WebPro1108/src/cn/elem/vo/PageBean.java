package cn.elem.vo;

import java.util.List;

public class PageBean<T> {
    private Integer totalRows;
    private Integer totalPages;
    private List<T> data;


    public PageBean() {
    }

    public PageBean(Integer totalRows, Integer totalPages, List<T> data) {
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.data = data;
    }

    /**
     * 获取
     * @return totalRows
     */
    public Integer getTotalRows() {
        return totalRows;
    }

    /**
     * 设置
     * @param totalRows
     */
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * 获取
     * @return totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * 设置
     * @param totalPages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 获取
     * @return data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    public String toString() {
        return "PageBean{totalRows = " + totalRows + ", totalPages = " + totalPages + ", data = " + data + "}";
    }
}
