        package com.example.a148894.exemplo_bd_relacional;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseErrorHandler;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

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
                                        "id integer primary key autoincrement, " +
                                        "nome text, " +
                                        "ano integer" +
                                        ")");

                sqLiteDatabase.execSQL("insert into Carros(nome, ano) " +
                        "values ('Fiorino', 1982)");

                sqLiteDatabase.execSQL("insert into Carros(nome, ano) " +
                        "values ('Chevete', 1990)");
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
                //            quando na nova versao do app, eh mudado algo no banco de dados
            }

            public void insertCar(Carro carro){
                SQLiteDatabase db = getWritableDatabase();

    //            db.execSQL("Insert into Carros...");
                ContentValues cValues = new ContentValues();
                cValues.put("nome", carro.nome);
                cValues.put("ano", carro.ano);
                db.insert("Carros", null, cValues);

                db.close();
            }
            public List<Carro> getCars(){
                SQLiteDatabase db = getReadableDatabase();

                List<Carro> listaCarros = new ArrayList<>();

                Cursor cursor =  db.query("Carros", null, null, null, null, null, "nome ask");

                while (cursor.moveToNext()){
                    Carro carro = new Carro();
                    carro.id = cursor.getInt(cursor.getColumnIndex("id"));
                    carro.nome = cursor.getString(cursor.getColumnIndex("nome"));
                    carro.ano = cursor.getInt(cursor.getColumnIndex("ano"));
                    listaCarros.add(carro);
                }
                db.close();
                return listaCarros;
            }

            public void deleteCara(int id){

                SQLiteDatabase db = getReadableDatabase();

                db.delete("Carros", "id = ?", new String[]{"" + id });


                db.close();

            }

            public void alterCar(Carro carro){
                SQLiteDatabase db = getWritableDatabase();

                //            db.execSQL("Insert into Carros...");
                ContentValues cValues = new ContentValues();
                cValues.put("nome", carro.nome);
                cValues.put("ano", carro.ano);
                db.update("Carros", cValues, "id = " + carro.id, null);

                db.close();
            }
        }
