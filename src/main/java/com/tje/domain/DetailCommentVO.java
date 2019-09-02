package com.tje.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class DetailCommentVO {
 private int cno;
 private String contentid;
 private String commentname;
 private int commentpw;
 private String commenttxt;
 private Date comment_date;
 private Date comment_update;
 private int liked;

}
