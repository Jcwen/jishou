package com.nd.jisou.data;

import java.util.ArrayList;

import com.nd.jisou.R;

public class CityData {
	private static  ArrayList<String> mCityList=new ArrayList<String>();
	private static String mCurrCity="����";
	public static  ArrayList<String> getCityList(){
		if(mCityList.size()==0){
			mCityList.add("����");
			mCityList.add("����");
			mCityList.add("���");
			mCityList.add("����");
			mCityList.add("ʯ��ׯ");
			mCityList.add("̫ԭ");
			mCityList.add("����");
			mCityList.add("������");
			mCityList.add("����");
			mCityList.add("����");
			mCityList.add("����");
			mCityList.add("�Ϻ�");
			mCityList.add("����");
			mCityList.add("����");
			mCityList.add("����");
			mCityList.add("����");
		}
		
		return mCityList;
	}
	
	public static void setCurrCity(String city){
		mCurrCity = city;
	}
	
	public static String getCurrCity(){
		return mCurrCity;
	}
}
