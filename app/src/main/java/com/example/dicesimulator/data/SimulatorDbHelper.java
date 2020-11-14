package com.example.dicesimulator.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SimulatorDbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSAO = 3;
    private static final String DB_NOME = "dice.db";

    public SimulatorDbHelper(Context context) {
        super(context, DB_NOME, null, DB_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlDestroyDB = "DROP TABLE IF EXISTS " + SimulatorContract.RoleEntry.TABELA_NOME;
        db.execSQL(sqlDestroyDB);

        String sqlCreateDB = "CREATE TABLE " + SimulatorContract.RoleEntry.TABELA_NOME + "("
                + SimulatorContract.RoleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + SimulatorContract.RoleEntry.COLUNA_NUM + " VARCHAR(20) NOT NULL)";

        db.execSQL(sqlCreateDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sqlDestroyDB = "DROP TABLE IF EXISTS " + SimulatorContract.RoleEntry.TABELA_NOME;
        db.execSQL(sqlDestroyDB);
        onCreate(db);
    }
}
