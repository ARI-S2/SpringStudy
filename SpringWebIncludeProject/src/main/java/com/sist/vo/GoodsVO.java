package com.sist.vo;

import lombok.Data;

/*
 GNO                                       NOT NULL NUMBER
 GNAME                                     NOT NULL VARCHAR2(1000)
 POSTER                                    NOT NULL VARCHAR2(1000)
 ORIGIN                                             VARCHAR2(300)
 MANUFACTURER                                       VARCHAR2(300)
 PRICE                                     NOT NULL VARCHAR2(100)
 DIMAGE                                             VARCHAR2(2000)
 */
@Data
public class GoodsVO {
	private int gno;
	private String gname,poster,origin,manufacturer,price,dimage;
}
