package cn.elem.query;

public class PageQuery {

    private Integer currentPage=1;
    private Integer pageNumber =5;//每页显示的记录数
    private Integer startIndex;//查询开始下标


    public PageQuery() {
    }

    public PageQuery(Integer currentPage, Integer pageNumber, Integer startIndex) {
        this.currentPage = currentPage;
        this.pageNumber = pageNumber;
        this.startIndex = startIndex;
    }

    /**
     * 获取
     * @return currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置
     * @param currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取
     * @return pageNumber
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * 设置
     * @param pageNumber
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 获取
     * @return startIndex
     */
    public Integer getStartIndex() {
        return (currentPage-1)*pageNumber;
    }

    /**
     * 设置
     * @param startIndex
     */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String toString() {
        return "PageQuery{currentPage = " + currentPage + ", pageNumber = " + pageNumber + ", startIndex = " + startIndex + "}";
    }
}
