package com.nt.Binding;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

public class DashbordDataBinding {

	private Integer totalCnt;
	private Integer enrolledCnt;
	private Integer lostCnt;
	
	
	
	public Integer getTotalCnt() {
		return totalCnt;
	}



	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}



	public Integer getEnrolledCnt() {
		return enrolledCnt;
	}



	public void setEnrolledCnt(Integer enrolledCnt) {
		this.enrolledCnt = enrolledCnt;
	}



	public Integer getLostCnt() {
		return lostCnt;
	}



	public void setLostCnt(Integer lostCnt) {
		this.lostCnt = lostCnt;
	}



	public DashbordDataBinding(Integer totalCnt, Integer enrolledCnt, Integer lostCnt) {
		super();
		this.totalCnt = totalCnt;
		this.enrolledCnt = enrolledCnt;
		this.lostCnt = lostCnt;
	}



	@Override
	public String toString() {
		return "DashbordDataBinding [totalCnt=" + totalCnt + ", enrolledCnt=" + enrolledCnt + ", lostCnt=" + lostCnt
				+ "]";
	}



	public DashbordDataBinding() {
		// TODO Auto-generated constructor stub
		
		
	}

}
