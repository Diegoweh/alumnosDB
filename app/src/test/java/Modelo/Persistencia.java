package Modelo;

import com.example.appdbalumnos.Alumno;

public interface Persistencia {
    public void openDataBase();
    public void closeDataBase();
    public long insertAlumno(Alumno alumno);
    public long updateAlumno(Alumno alumno);
    public void deleteAlumno(int id);
}
