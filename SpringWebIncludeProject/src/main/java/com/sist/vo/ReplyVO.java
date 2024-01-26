package com.sist.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int no,fno;
	private String id,name,msg;
	private Date dbdate;
}
