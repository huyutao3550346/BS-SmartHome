package com.zigbeee;

public class ZBAppReg {
	
	private byte endpoint;
	private byte[] appProfID = new byte[2];
	private byte[] appDeviceID = new byte[2];
	private byte endDevVer;
	private byte latencyReq;
	private byte appNumInClusters;
	private byte[] appInClusterList = new byte[0];
	private byte appNumOutClusters;
	private byte[] appOutClusterList = new byte[0];
	
	public ZBAppReg()
	{	
		endpoint = (byte) 0xff;
	}
	
	public ZBAppReg(ZBAppReg reg)
	{
		endpoint = reg.getEndpoint();
		setAppProfID(reg.getAppProfID());
		setAppDeviceID(reg.getAppDeviceID());
		endDevVer = reg.getEndDevVer();
		latencyReq = reg.getLatencyReq();
		appNumInClusters = reg.getAppNumInClusters();
		setAppInClusterList(reg.getAppInClusterList());
		appNumOutClusters = reg.getAppNumOutClusters();
		setAppOutClusterList(reg.getAppOutClusterList());
	}
	
	
	public byte getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(byte endpoint) {
		this.endpoint = endpoint;
	}

	public byte[] getAppProfID() {
		return appProfID;
	}

	public void setAppProfID(byte[] appProfID) {
		this.appProfID = appProfID.clone();
	}

	public byte[] getAppDeviceID() {
		return appDeviceID;
	}

	public void setAppDeviceID(byte[] appDeviceID) {
		this.appDeviceID = appDeviceID.clone();
	}

	public byte getEndDevVer() {
		return endDevVer;
	}

	public void setEndDevVer(byte endDevVer) {
		this.endDevVer = endDevVer;
	}

	public byte getLatencyReq() {
		return latencyReq;
	}

	public void setLatencyReq(byte latencyReq) {
		this.latencyReq = latencyReq;
	}

	public byte getAppNumInClusters() {
		return appNumInClusters;
	}

	public void setAppNumInClusters(byte appNumInClusters) {
		this.appNumInClusters = appNumInClusters;
		appInClusterList = new byte[appNumInClusters];
	}

	public byte[] getAppInClusterList() {
		return appInClusterList;
	}

	public void setAppInClusterList(byte[] appInClusterList) {
		this.appInClusterList = appInClusterList.clone();
		appOutClusterList = new byte[appNumOutClusters];
	}

	public byte getAppNumOutClusters() {
		return appNumOutClusters;
	}

	public void setAppNumOutClusters(byte appNumOutClusters) {
		this.appNumOutClusters = appNumOutClusters;
	}

	public byte[] getAppOutClusterList() {
		return appOutClusterList.clone();
	}

	public void setAppOutClusterList(byte[] appOutClusterList) {
		this.appOutClusterList = appOutClusterList.clone();
	}
}
