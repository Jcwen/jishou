package com.nd.jisou;

import com.nd.jisou.service.ILogService;
import com.nd.jisou.service.LogService;
import com.nd.jisou.utils.AppErrorLogHandler;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;


public class MyApplication extends Application {

	private static Context mContext;
    private static ILogService mLogService;
	 
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this.getApplicationContext();
		bindLogService();//����־����
		AppErrorLogHandler.getInstance(mContext); //��ʼ��������־����
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		unBindLogService();
	}
	
	public static Context getContext() {
		return mContext;
	}
	
	public static void writeFileLog(String log){
		if(mLogService!=null){
			mLogService.writeFileLog(mContext, log);
		}
	}
	
	/**
	 * ����־����
	 */
	private static void bindLogService(){
		if(mLogService==null){
			mContext.bindService(new Intent("com.nd.jisou.service.LogService"),
					serviceConnection, BIND_AUTO_CREATE);
		}
	}
	
	/**
	 * ȡ������־����
	 */
	private static void unBindLogService(){
			mContext.unbindService(serviceConnection);
	}
	
	
	/**
	 * ��־��������
	 */
   private static ServiceConnection  serviceConnection = new ServiceConnection() {

	        @Override
	        public void onServiceConnected(ComponentName name, IBinder service) {
	        	if(service instanceof ILogService){
		        	mLogService = (ILogService) service;
		            Log.v("ILogService", "on serivce connected");
	        	}
	        }

	        @Override
	        public void onServiceDisconnected(ComponentName name) {
	        	mLogService = null;
	        }
	    };

	   
	
}
