package com.example.buketbilgic.denizhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buket.bilgic on 12.04.2019.
 */

public class DT extends SQLiteOpenHelper {
      private static final String db_name="database_";
    private static final int db_version=1;


    public DT(Context context){super(context, db_name, null, db_version); };
    SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_Records (id INTEGER PRIMARY KEY AUTOINCREMENT, rc_date TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void dataADD(String kayit){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("rc_date",kayit);
         if(db.insert("tbl_Records",null,cv)>-1)
            Log.i("tag","İşlem Başarılı");
        else
            Log.e("tag","İşlem Başarısız");
        db.close();
    }
    public List<String> dataList(){
        List<String> kayitlar=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={"rc_date"};
        Cursor cr=db.query("tbl_Records",sutunlar,null,null,null,null,null);
        while(cr.moveToNext()){
            kayitlar.add(cr.getString(0));

        }
        return kayitlar;
    }
}
