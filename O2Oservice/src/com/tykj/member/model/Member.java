package com.tykj.member.model;

import java.util.Date;



import javax.persistence.Entity;

import com.tykj.util.base.BaseEntity;

/**
 * 会员实体类
 * */
@Entity
public class Member extends BaseEntity{
	private static final long serialVersionUID = 424202979131871626L;
	private int memberId;
	private String memberName;
	private String memberPassword;
	private int memberType;
	private int memberAuditStatus;
	private int token;
	private Date registerDate;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public int getMemberAuditStatus() {
		return memberAuditStatus;
	}
	public void setMemberAuditStatus(int memberAuditStatus) {
		this.memberAuditStatus = memberAuditStatus;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	

}
