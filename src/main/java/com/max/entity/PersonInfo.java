package com.max.entity;

import java.util.Date;

public class PersonInfo {
	private Long userId;//用户id
	private String name;//用户名
	private String profileImg;//用户头像地址
	private String email;//邮箱地址
	private String gender;//性别
	private Integer enableStatus;//用户状态
	private Integer userType;//1.顾客  2.店家  3.超级管理员
	private Date createTime;//创建时间
	private Date lastEditTime;//更新时间

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	@Override
	public String toString() {
		return "PersonInfo [userId=" + userId + ", name=" + name + ", profileImg=" + profileImg + ", email=" + email
				+ ", gender=" + gender + ", enableStatus=" + enableStatus + ", userType=" + userType + ", createTime="
				+ createTime + ", lastEditTime=" + lastEditTime + "]";
	}

}
