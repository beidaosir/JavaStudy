package com.hnu.query;

/**
 * 分页条件类
 */
public class BaseQuery {

    private Integer currentPage = 1;
    private Integer pageNumber = 5;

    public BaseQuery() {
    }

    public BaseQuery(Integer currentPage, Integer pageNumber) {
        this.currentPage = currentPage;
        this.pageNumber = pageNumber;
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

    /*
    只需要一个get方法即可  因为在sql中通过#{startIndex}取值时就是在调用getStartIndex
     */
    public Integer getStartIndex() {
        return (currentPage-1)*pageNumber;
    }

}