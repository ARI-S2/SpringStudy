package com.sist.dao;
/*
 * 
NO                                        NOT NULL NUMBER
 GOODS_NAME                                NOT NULL VARCHAR2(1000)
 GOODS_SUB                                          VARCHAR2(1000)
 GOODS_PRICE                               NOT NULL VARCHAR2(50)
 GOODS_DISCOUNT                                     NUMBER
 GOODS_FIRST_PRICE                                  VARCHAR2(20)
 GOODS_DELIVERY                            NOT NULL VARCHAR2(20)
 GOODS_POSTER                                       VARCHAR2(260)
 HIT                                                NUMBER
 */
public class GoodsVO {
	private String goods_name,goods_sub,goods_price,goods_discount,goods_delivery,goods_first_price;

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_sub() {
		return goods_sub;
	}

	public void setGoods_sub(String goods_sub) {
		this.goods_sub = goods_sub;
	}

	public String getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_discount() {
		return goods_discount;
	}

	public void setGoods_discount(String goods_discount) {
		this.goods_discount = goods_discount;
	}

	public String getGoods_delivery() {
		return goods_delivery;
	}

	public void setGoods_delivery(String goods_delivery) {
		this.goods_delivery = goods_delivery;
	}

	public String getGoods_first_price() {
		return goods_first_price;
	}

	public void setGoods_first_price(String goods_first_price) {
		this.goods_first_price = goods_first_price;
	}
	
	
}
