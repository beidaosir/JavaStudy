package com.hnu.query;

public class EmployeeQuery {

    //分页条件
    private Integer currentPage = 1;
    private Integer pageNumber = 5;
    //搜索条件
    private String ename;

    //获取开始查询的下标
    public Integer getStartIndex() {
        return (currentPage-1)*pageNumber;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}