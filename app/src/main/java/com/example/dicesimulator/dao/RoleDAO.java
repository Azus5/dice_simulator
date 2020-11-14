package com.example.dicesimulator.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dicesimulator.data.SimulatorContract;
import com.example.dicesimulator.data.SimulatorDbHelper;
import com.example.dicesimulator.model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private SQLiteDatabase db;

    public RoleDAO(Context context) {
        SimulatorDbHelper helper = new SimulatorDbHelper(context);
        db = helper.getWritableDatabase();
    }

    public void create(Role role) {
        ContentValues values = new ContentValues();

        values.put(SimulatorContract.RoleEntry.COLUNA_NUM, role.getNums());

        db.insert(SimulatorContract.RoleEntry.TABELA_NOME, null, values);
    }
    public List<Role> selectAll() {
        List lsRoles = new ArrayList<Role>();

        Cursor cursor = db.rawQuery("SELECT  * FROM roles", null);

        if (cursor.moveToFirst()) {
            do {
                Role role = new Role(0, "");
                role.setId(Integer.parseInt(cursor.getString(0)));
                role.setNums(cursor.getString(1));

                lsRoles.add(role);
            } while (cursor.moveToNext());
        }

        return lsRoles;

    }
    public void destroy(Role role) {}

}
