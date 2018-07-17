package com.zsz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetRow;
import com.zsz.dao.utils.JDBCUtils;
import com.zsz.dto.MerchantDTO;

public class MerchantDAO {
	public static MerchantDTO toDto(ResultSet rs) throws SQLException{
		MerchantDTO merchant = new MerchantDTO();
		if(rs!=null){
			merchant.setAddress(rs.getString("address"));
			merchant.setBossIdCardPicUrl(rs.getString("bossIdCardPicUrl"));
			merchant.setBossName(rs.getString("bossName"));
			merchant.setBusinessLicenseUrl(rs.getString("businessLicenseUrl"));
			merchant.setDeleted(rs.getBoolean("isDeleted"));
			merchant.setFailReason(rs.getString("failReason"));
			merchant.setId(rs.getLong("id"));
			merchant.setIdCardNum(rs.getString("idCardNum"));
			merchant.setName(rs.getString("name"));
			merchant.setRegionName(rs.getString("regionName"));
			merchant.setPhoneNum(rs.getString("phoneNum"));
			merchant.setRegionId(rs.getLong("regionId"));
			merchant.setStatus(rs.getString("status"));
			merchant.setTypeId(rs.getLong("typeId"));
			
		}
		return merchant;
	}
	
	public MerchantDTO[] getAllMerchant(){
		StringBuilder sb = new StringBuilder();
		sb.append("select m.*,r.name regionName from t_merchants m \n");
		sb.append("left join t_merchantTypes mt on mt.id = m.typeId \n ");
		sb.append("left join t_regions r on r.id = m.regionId \n");
		ResultSet rs= null;
		List<MerchantDTO> list = new ArrayList<>();
		try {
			rs  = JDBCUtils.executeQuery(sb.toString());
			while(rs.next()){
				list.add(toDto(rs));
			}
			return list.toArray(new MerchantDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.closeAll(rs);
		}
	}
	
	public void applyMerchant(MerchantDTO merchant){
		StringBuilder sb = new StringBuilder();
		sb.append("insert into T_merchants(name,address,regionId,PhoneNum,typeId,"
				+ "idCardNum,bossIdCardPicUrl,businessLicenseUrl,bossName,status) \n");
		try {
			JDBCUtils.executeInsert(sb.toString(), merchant.getName(),merchant.getAddress(),merchant.getRegionId(),
					merchant.getPhoneNum(),merchant.getTypeId(),merchant.getIdCardNum(),merchant.getBossIdCardPicUrl(),
					merchant.getBusinessLicenseUrl(),merchant.getBossName(),"审核中");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void passMerchant(long id){
		StringBuilder sb = new StringBuilder();
		sb.append("update T_merchant set status = '已启用' where id = ? \n");
		try {
			JDBCUtils.executeNonQuery(sb.toString(), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void killMerchant(long id,String failReason){
		StringBuilder sb = new StringBuilder();
		sb.append("update T_merchant set status = '下架' ,failReason = ? where id = ? \n");
		try {
			JDBCUtils.executeNonQuery(sb.toString(), id,failReason);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
