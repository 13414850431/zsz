package com.zsz.service;

import com.zsz.dao.MerchantDAO;
import com.zsz.dto.MerchantDTO;

public class MerchantService {
	MerchantDAO dao =new MerchantDAO();
	
	public MerchantDTO[] getAllMerchant(){
		return dao.getAllMerchant();
	}
	
	public void applyMerchant(MerchantDTO merchant){
		dao.applyMerchant(merchant);
	}
	
	public void passMerchant(long id){
		dao.passMerchant(id);
	}
	
	public void killMerchant(long id,String failReason){
		dao.killMerchant(id, failReason);
	}
}
