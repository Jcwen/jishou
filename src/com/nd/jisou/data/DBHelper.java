package com.nd.jisou.data;

import com.nd.jisou.MyApplication;
import com.nd.jisou.service.LogService;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	private static final String TAG = "DBHelper";

	/** ���ݿ��� **/
	public static final String DATABASE_NAME = "jisou";
	/** ���ݿ�汾�� **/
	public static int DATABASE_VERSION = 1;

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * ���ݿⴴ�������ݳ�ʼ��
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG, "onCreate");
		MyApplication.writeFileLog("DBHelper onCreate");
		try {
				db.execSQL("CREATE TABLE IF NOT EXISTS [house] ([house_name] nvarchar(20), [title] nvarchar(50),  [address] nvarchar(50), [price] INT DEFAULT 0, [unit_price] INT, [toward] nvarchar(20), [apartment] nvarchar(20), [decoration] nvarchar(20), [area] INT, [house_type] CHAR, [floors] CHAR, [years] INT,[favorite] INT DEFAULT 0,[pic_index] INT DEFAULT 0);");
				db.execSQL("insert into house values('��ͷ��԰','ʮ���г���·�����ϻ��ͣ��ƽ�¥��','������·',115,9800,'����','3��2��1��','��ͨװ��',117,'��ͨסլ','6/7',1997,0,1);");
				db.execSQL("insert into house values('�����³�','����վ����С����','�׺�ͤ����',102,13200,'�ϱ�',	'2��2��1��',	'��װ��',	77,	'��ͨסլ',	'17/18',2011,0,2);");
				db.execSQL("insert into house values('�и���','�ϱ�ͨ͸����װ��',	         '����·',	    118,16400,'�ϱ�','2��1��1��','��װ��',	72,'��ͨסլ','10/18',2012,0,3);");
				db.execSQL("insert into house values('��̩�´�','���ֿ����������������ĵض�', '���ֿ�',	    115,18300,'��',  '2��2��1��','��װ��',	63,'��ͨסլ','2/8'	 ,1998,0,4);");
				db.execSQL("insert into house values('����ˮ��','ϡȱ����������112��',	       '�������',  112,15300,'����','2��2��1��','��װ��',	73,'��ͨסլ','1/11'	,2006,0,5);");
				db.execSQL("insert into house values('��ϼ�³�','������·��������' ,          '��һ����·',	112,14700,'��',  '3��2��1��','��װ��',	76,'��ͨסլ','3/7' 	,2004,0,6);");
				db.execSQL("insert into house values('����С��','�¶��ֿڡ��ػݷ�'	,         '���ֿ�',	    105,15900,'�ϱ�','2��2��1��','��װ��',	66,'��ͨסլ','3/7' 	,2000,0,7);");
				db.execSQL("insert into house values('����С��','�÷������ˣ���������',	     '����·'	,     104,11399,'�ϱ�','3��2��2��','ë��',    91,'��ͨסլ','6/6'	 ,2006,0,8);");
				db.execSQL("insert into house values('������Է','��ﱳ��1.1��ķ���������','�������',	  110,12000,'�ϱ�','3��2��2��','��װ��',	92,'��ͨסլ','2/6' 	,2004,0,9);");
				db.execSQL("insert into house values('�㸣��԰','������ʩ��ȫ���Լ۱ȸ�',	   '��һ�㳡'	,   118,15500,'��',  '2��2��1��','��װ��',	76,'��ͨסլ','7/8'	 ,2009,0,10);");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.d(TAG, "onCreate end");
		MyApplication.writeFileLog("DBHelper onCreate end");
	}

	public boolean isTableExist(SQLiteDatabase db, String tableName) {
		boolean result = false;
		if (tableName == null) {
			return false;
		}

		try {
			Cursor cursor = null;
			String sql = "select count(1) as c from sqlite_master where type ='table' and name ='"
					+ tableName.trim() + "'";
			cursor = db.rawQuery(sql, null);
			if (cursor.moveToNext()) {
				int count = cursor.getInt(0);
				if (count > 0) {
					result = true;
				}
			}

			cursor.close();
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}



}
