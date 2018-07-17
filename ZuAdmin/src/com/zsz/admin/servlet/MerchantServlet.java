package com.zsz.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsz.dto.MerchantTypeDTO;
import com.zsz.service.MerchantTypeService;
import com.zsz.tools.AjaxResult;
import com.zsz.tools.CommonUtils;

@WebServlet("/Merchant")
public class MerchantServlet extends BaseServlet {
	
	MerchantTypeService merchantTypeService = new MerchantTypeService();
	
	public void showMerType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		MerchantTypeDTO[] types = merchantTypeService.getAllMerchantTypes();
		req.setAttribute("types", types);
		req.getRequestDispatcher("/WEB-INF/merchant/merchantTypeList.jsp").forward(req, resp);
	}
	
	public void addType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/WEB-INF/merchant/merchantTypeAdd.jsp").forward(req, resp);
	}
	
	public void addTypeSubmit(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//名称不能为空
		String name  = req.getParameter("typeName");
		if(CommonUtils.isNullOrWhiteSpace(name)){
			writeJson(resp, new AjaxResult("error","名称不能为空"));
		}
		String description = req.getParameter("typeDescription");//获得商品分类描述
		
		merchantTypeService.addMerchantType(name, description);
		
		writeJson(resp, new AjaxResult("ok"));
		
	}
	
	public void editType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		//拿到id
		long id = Long.parseLong(req.getParameter("id"));
		
		MerchantTypeDTO  merchantType = merchantTypeService.getById(id);
		
		req.setAttribute("merchantType", merchantType);
		
		req.getRequestDispatcher("/WEB-INF/merchant/merchantTypeEdit.jsp").forward(req, resp);;
		
	}
	
	public void editTypeSubmit(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		long id = Long.parseLong(req.getParameter("id"));
		
		//名称不能为空
		String name  = req.getParameter("typeName");
		if(CommonUtils.isNullOrWhiteSpace(name)){
			writeJson(resp, new AjaxResult("error","名称不能为空"));
		}
		String description = req.getParameter("typeDescription");//获得商品分类描述
		
		merchantTypeService.updateMerchantType(id,name, description);
		
		writeJson(resp, new AjaxResult("ok"));
		
	}
	
	public void delType(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//那要删除的分类id
		long id = Long.parseLong(req.getParameter("id"));
		
		//查找该分类下是否存在商家，有就报错
		int count = merchantTypeService.countMerchantByType(id);
		
		if(count>0){
			writeJson(resp, new AjaxResult("error","不可以删除非空的分类"));
			return;
		}
		writeJson(resp, new AjaxResult("ok"));
		
	}

}
