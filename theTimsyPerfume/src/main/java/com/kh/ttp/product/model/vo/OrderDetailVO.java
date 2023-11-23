package com.kh.ttp.product.model.vo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderDetailVO {
	/*
	ORDER_DETAIL_NO	NUMBER
	ORDER_NO	NUMBER
	PDT_NO	NUMBER
	PAY_NO	NUMBER
	ORDER_PRICE	NUMBER
	ORDER_QUANTITY	NUMBER
	*/
	private int orderDetailNo;
	
	private PayVO pay;
	private OrderVO order;
	
	private ArrayList<ProductVO> product;
	
}