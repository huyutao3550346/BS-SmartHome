package com.zigbeee;

import java.util.ArrayList;

import com.port.Message;
import com.port.MessageReceiveCallBack;
import com.port.MyPortClient;

public class Zigbee {
	
	private int receiveTimeou = 300;
	private ZBCfg zbCfg;
	private ArrayList<ZBAppReg> appRegList = new ArrayList<ZBAppReg>();
	private MyPortClient portClient;
	
	public Zigbee(){
		
	}
	
	public Zigbee(ZBCfg cfg){
		setZBCfg(cfg);
	}
	
	public Zigbee(ArrayList<ZBAppReg> appRegList){
		
		setAppRegs(appRegList);
		this.zbCfg = new ZBCfg();
	}
	
	public Zigbee(ZBCfg cfg, ArrayList<ZBAppReg> appRegList){
		setZBCfg(cfg);
		setAppRegs(appRegList);
	}
	
	public void setZBCfg(ZBCfg cfg){
		this.zbCfg = new ZBCfg(cfg);
	}
	
	public void setZDType(ZBDeviceType zdType){
		zbCfg.setZdType(zdType);
	}
	
	public void setAppRegs(ArrayList<ZBAppReg> appRegList){	//设置应用注册信息
		if(appRegList == null)
			return;
		if(this.appRegList == null)
			this.appRegList = new ArrayList<ZBAppReg>();
		
		for(int i=0; i<appRegList.size(); i++){
			this.appRegList.add(new ZBAppReg(appRegList.get(i)));
		}
	}
	
	public void sendReceiveTimeout(int timeout){	//设置接收数据包超时时间，单位为ms
		this.receiveTimeou = timeout;
	}

	public void init(){
		System.out.println("zigbee begin init");
		try{
			
			portClient.send(ZBCG.CMD_DEVICE_RESET);
			Thread.currentThread().sleep(2000);
			
			portClient.send(ZBCG.CMD_STARTUP_WITHOUT_LAST_STATE);
			Thread.currentThread().sleep(500);
			
			portClient.send(ZBCG.CMD_DEVICE_RESET);
			Thread.currentThread().sleep(2000);
			
			portClient.send(ZBCG.CMD_ZDO_DIRECT_CB);
			Thread.currentThread().sleep(500);
			
			portClient.send(ZBCG.CMD_DEVICE_RESET);
			Thread.currentThread().sleep(2000);
			
			portClient.send(ZBCG.chanlistCfg(ZBCG.DEFAULT_CHANNEL));
			Thread.currentThread().sleep(500);
			
			portClient.send(ZBCG.PANIDCfg(ZBCG.DEFAULT_PANID));
			Thread.currentThread().sleep(500);
			
			portClient.send(ZBCG.deviceTypeCfg(ZBCG.DEVICE_TYPE_COORDINATOR));
			Thread.currentThread().sleep(500);
			
			ZBAppReg reg = new ZBAppReg();
			reg.setEndpoint((byte) 0x78);
			portClient.send(ZBCG.appRegister(reg));
			Thread.currentThread().sleep(500);
			
			System.out.println("zigbee begin has inited");

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void start() throws InterruptedException{
		
		portClient.send(ZBCG.CMD_STARTUP_FROM_APP);
		Thread.currentThread().sleep(2000);
		
		System.out.println("zigbee start");
		
	}
	
	public void setPortClient(MyPortClient client){
		this.portClient = client;
	}
}
