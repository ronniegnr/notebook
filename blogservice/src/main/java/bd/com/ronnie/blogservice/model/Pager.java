package bd.com.ronnie.blogservice.model;

import org.springframework.data.domain.Page;

import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Pager<T> {

    private Integer currentPage;
    private Long totalItemCount;
    private Integer pageCount;
    private String url;

    private String firstPageUrl;
    private String previousPageUrl;
    private String nextPageUrl;
    private String lastPageUrl;

    private Pager() {
    }

    public Pager(Page<T> tPage, String url) {
        this.currentPage = tPage.getNumber();
        this.totalItemCount = tPage.getTotalElements();
        this.pageCount = tPage.getTotalPages();
        this.url = url;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Long getTotalItemCount() {
        return totalItemCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getUrl() {
        return url;
    }

    public String getFirstPageUrl() {
        return url + "0";
    }

    public String getPreviousPageUrl() {
        return url + max(currentPage - 1, 0);
    }

    public String getNextPageUrl() {
        return url + min(currentPage + 1, pageCount - 1);
    }

    public String getLastPageUrl() {
        return url + (pageCount - 1);
    }

}
