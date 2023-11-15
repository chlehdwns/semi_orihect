package com.kh.ttp.product.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.ttp.funding.model.vo.Funding;
import com.kh.ttp.product.model.service.ProductService;
import com.kh.ttp.product.model.vo.Product;
import com.kh.ttp.productCategory.model.vo.ProductCategory;
import com.kh.ttp.productFile.model.vo.ProductFile;
import com.kh.ttp.productOption.model.vo.ProductOption;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 상품 메인페이지 조회 기능
	 * @return
	 */
	@GetMapping("productMain.pr")
	public String productMain(@RequestParam (value="pdtIdenKey", defaultValue="M")String pdtIdenKey,
											 int pdtNo) { // Q.알아서 관리하니까 불변객체 자원소모는 신경 안써도 되나?
		
		if("A".equals(pdtIdenKey.toUpperCase())) {
			// 알콜 조회 A
			System.out.println("알콜조회");
			
			
			
		} else if("P".equals(pdtIdenKey.toUpperCase())) {
			// 향수 조회 P
			System.out.println("향수조회");
			
			
			
		} else {
			System.out.println("기타등등");
			// common/errorPage  ${ errorMsg }
		}
		System.out.println("스코프 밖");
		
		// pdtIdenKey넘겨줘야함 (식별자 보고 div띄워줄 것) 
		return "product/productMain";
	}
	@RequestMapping("insertDrink.fun")
	public String drinkFundinginsert(MultipartFile upfile,HttpSession session,Model model,String pdtName,String pdtIntro,String pdtDescription,String pdtShipping, int cuttingPrice,int pdtPrice,Date cuttingDate,String pdtManufac,String pdtGroup,String pdtIngredient) {
		//System.out.println(upfile);
		//System.out.println(pdtName);
		//System.out.println(pdtIntro);
		//System.out.println(pdtDescription);
		//System.out.println(pdtShipping);
		//System.out.println(cuttingPrice);
		//System.out.println(pdtPrice);
		//System.out.println(cuttingDate);
		//System.out.println(pdtManufac);
		//System.out.println(pdtGroup);
		//System.out.println(pdtIngredient);
		Product p = new Product();
		p.setPdtName(pdtName);
		p.setPdtIntro(pdtIntro);
		p.setPdtDescription(pdtDescription);
		p.setPdtShipping(pdtShipping);
		p.setPdtPrice(pdtPrice);
		p.setPdtIngredient(pdtIngredient);
		ProductCategory pc = new ProductCategory();
		pc.setPdtManufac(pdtManufac);
		pc.setPdtGroup(pdtGroup);
		
		
		ProductFile pf = new ProductFile();
		
		ProductOption po = new ProductOption();
		
		Funding f = new Funding();
		f.setCuttingDate(cuttingDate);
		f.setCuttingPrice(cuttingPrice);
		
		if(!upfile.getOriginalFilename().equals("")) {
			pf.setPdtFileOrigin(upfile.getOriginalFilename());
			pf.setPdtFileUpload(saveFile(upfile,session));
		}
		productService.drinkFundingInsert(p,pf,po,f,pc);
		
		
		
		
		
		return "";
	}
	private String saveFile(MultipartFile upfile, HttpSession session) {
		String originName = upfile.getOriginalFilename();
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		int ranNum = (int)(Math.random() * 9000) + 1000;
		
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = currentTime + ranNum +ext;
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		return "/resources/uploadFiles/" + changeName;
	}

}
