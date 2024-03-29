package model;

import java.util.List;

public class Page {
  private int pageNumber;//歌曲分页数
  private int pageSize;//页面歌曲数
  private int totalCount;//总歌曲数
  private int totalPage;//总页数

  private List<Object> list;//歌曲list

  public void SetPageSizeAndTotalCount(int pageSize,int totalCount)
  {
    this.pageSize=pageSize;
    this.totalCount=totalCount;
    totalPage= (int)Math.ceil((double)totalCount/pageSize);
  }
  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public List<Object> getList() {
    return list;
  }

  public void setList(List<Object> list) {
    this.list = list;
  }
}
