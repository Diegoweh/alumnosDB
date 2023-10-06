package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.appdbalumnos.Alumno;

import org.junit.runner.manipulation.Ordering;

import java.util.ArrayList;

public class AlumnoDb implements Persistencia, Proyeccion{
    private Context context;
    private AlumnoDbHelper helper;
    private SQLiteDatabase db;
     //constructor

    public AlumnoDb(Context context) {
        this.context = context;
    }

    public AlumnoDb(Context context, AlumnoDbHelper helper) {
        this.context = context;
        this.helper = helper;
    }

    @Override
    public void openDataBase() {
        db = helper.getWritableDatabase();

    }

    @Override
    public void closeDataBase() {
        helper.close();

    }

    @Override
    public long insertAlumno(Alumno alumno) {
        ContentValues values = new ContentValues();
        values.put(DefineTabla.Alumnos.COLUMN_NAME_MATRICULA,alumno.getMatricula());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_NOMBRE,alumno.getNombre());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_CARRERA,alumno.getCarrera());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_FOTO,alumno.getImagen());

        this.openDataBase();
        long num = db.insert(DefineTabla.Alumnos.TABLE_NAME, null,values);
        this.closeDataBase();
        Log.d("Alumnos", "Se agrego registro" + num);
        return num;
    }

    @Override
    public long updateAlumno(Alumno alumno) {
        return 0;
    }

    @Override
    public void deleteAlumno(int id) {
        this.openDataBase();
        db.delete(DefineTabla.Alumnos.TABLE_NAME,DefineTabla.Alumnos.COLUMN_NAME_ID + "=?",
                new String[]{String.valueOf(id)});
        this.closeDataBase();
    }

    @Override
    public Alumno getAlumno(String matricula) {
        return null;
    }

    @Override
    public ArrayList<Alumno> allAlumnos() {
        return null;
    }

    @Override
    public Alumno readAlumno(Cursor cursor) {
        return null;
    }
}
