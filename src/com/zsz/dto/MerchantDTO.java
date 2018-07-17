package com.zsz.dto;

public class MerchantDTO {
	private long id ;//主键
	private String name;//商家名称
	private String address;//商家地址
	private long regionId;//所属的小区
	private String regionName;//所属区域的名字
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	private String PhoneNum;//手机号码
	private long typeId;//商家的类型
	private String idCardNum;//经营者身份证号
	private String bossIdCardPicUrl;//身份证照片的图片链接
	private String businessLicenseUrl;//营业执照的图片链接
	private String bossName;//经营者名字
	private String status;//商家状态
	private String failReason;//失败原因
	private boolean isDeleted;//软删除
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getBossIdCardPicUrl() {
		return bossIdCardPicUrl;
	}
	public void setBossIdCardPicUrl(String bossIdCardPicUrl) {
		this.bossIdCardPicUrl = bossIdCardPicUrl;
	}
	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}
	public void setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
	}
	public String getBossName() {
		return bossName;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
