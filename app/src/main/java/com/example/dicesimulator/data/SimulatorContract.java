package com.example.dicesimulator.data;

import android.provider.BaseColumns;

import java.sql.Timestamp;
import java.util.Calendar;

public class SimulatorContract {
    public static final class RoleEntry implements BaseColumns {
        public static final String TABELA_NOME = "roles";
        public static final String COLUNA_NUM = "nums";
    }
}
