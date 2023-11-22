package com.kh.ttp.product.model.service;


import java.util.ArrayList;

import com.kh.ttp.common.model.vo.PageInfo;
import com.kh.ttp.funding.model.vo.Funding;
import com.kh.ttp.product.model.vo.FundingSelectVO;
import com.kh.ttp.product.model.vo.ProductSelectVO;
import com.kh.ttp.product.model.vo.ProductVO;
import com.kh.ttp.productCategory.model.vo.ProductCategory;
import com.kh.ttp.productFile.model.vo.ProductFile;
import com.kh.ttp.productOption.model.vo.ProductOption;

public interface ProductService {
	
	// 프로젝트 메인 조회 메소드(SELECT)
	public ArrayList<ProductSelectVO> productMain(String pdtIdenKey);

	int drinkFundingInsert(ProductVO p, ProductFile pf, ProductOption po, Funding f, ProductCategory pc);
	
	int updateDrinkFunding(ProductVO p, ProductFile pf, ProductOption po, Funding f, ProductCategory pc);

	public ArrayList<FundingSelectVO> selectNewFundingList();

	public int newDrinkFundingListCount();

	public ArrayList<FundingSelectVO> newDrinkFundingList(PageInfo pi);

	public FundingSelectVO newDrinkFundingDetail(int pdtNo);

	public int increaseCount(int pdtNo);

	public ArrayList<FundingSelectVO> selectHotFundingList();

	public ArrayList<FundingSelectVO> hotDrinkFundingList(PageInfo pi);

	public FundingSelectVO selectDrinkFundingList(int pdtNo);

	public int deleteDrinkFunding(int pdtNo);

	





}
