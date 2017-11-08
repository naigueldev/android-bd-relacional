    package com.example.a148894.exemplo_bd_relacional;

    import android.content.Context;
    import android.database.DatabaseErrorHandler;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    /**
     * Created by 148894 on 08/11/2017.
     */

    public class BDmanager extends SQLiteOpenHelper {
    //    public BDmanager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    //        super(context, name, factory, version);
    //    }

        public BDmanager(Context ctx) {
            super(ctx, "CarroDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table Carros (" +
                                    "id serial primary key, " +
                                    "nome text, " +
                                    "ano integer" +
                                    ")");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
