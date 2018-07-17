package com.zsz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dao.utils.JDBCUtils;
import com.zsz.dto.MerchantTypeDTO;

public class MerchantTypeDAO {
	
	public static MerchantTypeDTO toDto(ResultSet rs) throws SQLException{
		MerchantTypeDTO dto = new MerchantTypeDTO();
		if(rs!=null){
			dto.setId(rs.getLong("id"));
			dto.setName(rs.getString("name"));
			dto.setDescription(rs.getString("description"));
			dto.setDeleted(rs.getBoolean("isDeleted"));
		}
		return dto;
	}
	
	public  void addMerchantType(String name,String description){
		StringBuilder sb = new StringBuilder();
		sb.append("insert into t_merchantTypes(name,description) values(?,?) \n");
		try {
			JDBCUtils.executeInsert(sb.toString(), name,description);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public MerchantTypeDTO[] getAllMerchantTypes(){
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_merchantTypes \n");
		ResultSet rs = null;
		List<MerchantTypeDTO> list = new ArrayList<>();
		
		try {
			rs = JDBCUtils.executeQuery(sb.toString());
			while(rs.next()){
				list.add(toDto(rs));
			}
			return list.toArray(new MerchantTypeDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.closeAll(rs);
		}
	}
	
	public  void updateType(long id,String name,String description){
		StringBuilder sb = new StringBuilder();
		sb.append("update t_merchantTypes set name = ? ,set description = ? where id = ? ");
		try {
			JDBCUtils.executeNonQuery(sb.toString(), name,description,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void markDeleted(long id){
		StringBuilder sb = new StringBuilder();
		sb.append("update t_merchantTypes set isDeleted = 0 where id = ? ");
		try {
			JDBCUtils.executeNonQuery(sb.toString(),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public MerchantTypeDTO getById(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_merchantTypes where id = ? \n");
		ResultSet rs = null;
		try {
			rs  = JDBCUtils.executeQuery(sb.toString(), id);
			if(rs.next()){
				return toDto(rs);
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.closeAll(rs);
		}
	}

	public void updateMerchantType(long id, String name, String description) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("update t_merchantTypes set name = ?,description = ? where id =? \n");
		try {
			JDBCUtils.executeNonQuery(sb.toString(), name,description,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int countMerchantByType(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from t_merchants where typeId = ? \n	");
		Number num;
		
		try {
			num = (Number) JDBCUtils.querySingle(sb.toString(), id);
			
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	
	
}
