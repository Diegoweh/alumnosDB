package Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AlumnoDbHelper extends SQLiteOpenHelper {

    private static final  String TEXT_TYPE = " TEXT";
    private static final  String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = " , ";

    private static final String SQL_CREATE_ALUMNO = " CREATE TABLE " +
            DefineTabla.Alumnos.TABLE_NAME + " (" +
            DefineTabla.Alumnos.COLUMN_NAME_ID + "INTEGER PRIMARY KEY, " +
            DefineTabla.Alumnos.COLUMN_NAME_MATRICULA + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Alumnos.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Alumnos.COLUMN_NAME_CARRERA + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Alumnos.COLUMN_NAME_FOTO + TEXT_TYPE + ")";

    private static final String SQL_DELETE_ALUMNO = "DROP TABLE IF EXISTS " +
            DefineTabla.Alumnos.TABLE_NAME;
    private static final String DATABASE_NAME = "dbAlumnos";
    private static final int DATA_VERSION = 1;



    public AlumnoDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ALUMNO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ALUMNO);
        onCreate(db);
    }
}
