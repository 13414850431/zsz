package com.zsz.service;

import com.zsz.dao.MerchantDAO;
import com.zsz.dao.MerchantTypeDAO;
import com.zsz.dto.MerchantTypeDTO;

public class MerchantTypeService {
	MerchantTypeDAO dao = new MerchantTypeDAO();
	public  void addMerchantType(String name,String description){
		dao.addMerchantType(name, description);
	}
	
	public MerchantTypeDTO[] getAllMerchantTypes(){
		return dao.getAllMerchantTypes();
	}
	
	public  void updateType(long id,String name,String description){
		dao.updateType(id, name, description);
	}
	
	public void markDeleted(long id){
		dao.markDeleted(id);
	}

	public MerchantTypeDTO getById(long id) {
		return dao.getById(id);
	}

	public void updateMerchantType(long id, String name, String description) {
		// TODO Auto-generated method stub
		dao.updateMerchantType(id,name,description);
	}

	public int countMerchantByType(long id) {
		// TODO Auto-generated method stub
		return dao.countMerchantByType(id);
	}
}
