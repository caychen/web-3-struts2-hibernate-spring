package org.com.cay.entity;

import java.sql.Date;

public class Cost extends Entity{
	private Integer id;//�ʷ�ID
	private String name;//�ʷ�����
	private Integer baseDuration;//������ʱ��
	private Float baseCost;//�¹̶���
	private Float unitCost;//��λ����
	private String status;//״̬��0����ͨ��1����ͣ
	private String descr;//�ʷ���Ϣ˵��
	private Date createTime;//��������
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	private Date startTime;//��������
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Float getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}
	public Float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  id + "," + name
				+ "," + baseDuration + "," + baseCost + ","
				+ unitCost	+ "," + status + "," + descr
				+ "," + createTime + "," + startTime;
	}
}
