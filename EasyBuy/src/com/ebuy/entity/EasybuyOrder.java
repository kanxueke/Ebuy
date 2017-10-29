package com.ebuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 订单实体类
 *
 */
public class EasybuyOrder implements Serializable {
	private int id;						//订单id
	private int userId;					//用户id
	private String loginName;			//用户登陆名
	private String userAddress;			//用户地址
	private Date crateTime;				//创建时间
	private double cost;				//金额
	private int status;					//状态，1：待审核；2：通过审核；3：配货；4：已发货；5：已收货
	private int type;					//类型？
	private String serialNumber;		//订单号？
	
	
	//各属性get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	//无参构造
	public EasybuyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	//全参构造
	public EasybuyOrder(int id, int userId, String loginName,
			String userAddress, Date crateTime, double cost, int status,
			int type, String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.crateTime = crateTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
		this.serialNumber = serialNumber;
	}
	
	//toString
	@Override
	public String toString() {
		return "EasybuyOrder [id=" + id + ", userId=" + userId + ", loginName="
				+ loginName + ", userAddress=" + userAddress + ", crateTime="
				+ crateTime + ", cost=" + cost + ", status=" + status
				+ ", type=" + type + ", serialNumber=" + serialNumber + "]";
	}
	
	
	
	
	
	
	
}
