package bd.com.ronnie.blogservice.model;

import org.springframework.data.domain.Page;

public class Pager<T> {

    private Integer currentPageNo;
    private Long totalPostCount;
    private Integer pageCount;

    private Pager() {
    }

    public Pager(Page<T> tPage) {
        this.currentPageNo = tPage.getNumber();
        this.totalPostCount = tPage.getTotalElements();
        this.pageCount = tPage.getTotalPages();
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public Long getTotalPostCount() {
        return totalPostCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }
}
