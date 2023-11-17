package com.kh.ttp.product_mjy.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ttp.common.model.vo.PageInfo;
import com.kh.ttp.common.template.Pagination;
import com.kh.ttp.product_mjy.model.service.ProductService1;

@Controller
public class ProductController1 {

	@Autowired
	private ProductService1 productService;
	
	
	
	// AF / 6개 12개 // New / BestSeller / Popular // 다 넘기고 전부 mybatis에서 검증
	/**
	 * @param pdt : 
	 * @param mv
	 * @return
	 * 
	 * productMain.pr?pdtCteg=A&sort=New&pdtQuan=6
	 * productMain.pr?pdtCteg=A&sort=New&pdtQuan=12&currentPage=현재페이지
	 */
	/**
	 * @param sort : 정렬 기준
	 * @param pdtCteg : 주류 향수 구분, 주류 = A, 향수 = F
	 * @param mv
	 * @return
	 */
	@GetMapping("productMain.pr") // productMain.pr?pdtCteg=A&sort=New&pdtQuan=6
	public ModelAndView productMainList(String pdtCteg, ModelAndView mv) {
		
		
		int listCount = productService.selectProductCount(pdtCteg);
		PageInfo pi = Pagination.getPageInfo(listCount, 1, 6, 10);
		RowBounds rowBounds = new RowBounds(0, pi.getBoardLimit());
		
		mv.addObject("productMainList", productService.productMainList(pdtCteg, rowBounds))
		  .addObject("pdtCteg", pdtCteg) // 주류 / 향수 식별자
		  .setViewName("product/productMain");
		return mv;
	}
	
}
