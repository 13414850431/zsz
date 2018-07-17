package com.zsz.service;

import com.zsz.dao.CityDAO;
import com.zsz.dto.CityDTO;
import com.zsz.dto.UserDTO;

public class CityService {
	private CityDAO dao = new CityDAO();

	// 根据id获取城市DTO
	public CityDTO getById(long id) {
		return dao.getById(id);
	}

	// 获取所有城市
	public CityDTO[] getAll() {
		return dao.getAll();
	}

	public CityDTO getCityByName(String cityName) {
		return dao.getCityByName(cityName);
	}
}
