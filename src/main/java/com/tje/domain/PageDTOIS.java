package com.tje.domain;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTOIS {

  private int startPage;
  private int endPage;
  private boolean prev, next;

  private int pageNo;
  private int numOfRows;
  private int totalCount;

  public PageDTOIS(int pageNo, int numOfRows, int totalCount) {

    
    this.totalCount = totalCount;
    this.pageNo = pageNo;
    this.numOfRows = numOfRows;

    this.endPage = (int) (Math.ceil(pageNo / 10.0)) * 10;

    this.startPage = this.endPage - 9;

    int realEnd = (int) (Math.ceil((totalCount * 1.0) / numOfRows ));

    if (realEnd <= this.endPage) {
      this.endPage = realEnd;
    }

    this.prev = this.startPage > 1;

    this.next = this.endPage < realEnd;
  }
  
}
