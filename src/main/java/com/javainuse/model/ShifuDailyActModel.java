/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.model;

/**
 *
 * @author surajit.samui
 */
public class ShifuDailyActModel {
    	
	private long prsId;
	private int tenantId;

	public ShifuDailyActModel() {

	}

	public ShifuDailyActModel(long prsId, int tenantId) {
		super();
		this.prsId = prsId;
		this.tenantId = tenantId;
	}

	public long getPrsId() {
		return prsId;
	}

	public void setPrsId(long prsId) {
		this.prsId = prsId;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String toString() {
		return "ShifuDailyActModel [prsId=" + prsId + ", tenantId=" + tenantId + "]";
	}

}
