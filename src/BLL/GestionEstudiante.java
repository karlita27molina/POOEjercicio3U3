package BLL;

import BEU.Curso;
import BEU.Estudiante;
import Molina.BasePersistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestionEstudiante extends BasePersistencia<Estudiante> {

    private List<Estudiante> estudiante = new ArrayList();
    private final String directorio="estudiantes";


    public GestionEstudiante() {       
    }
    public List<Estudiante>getEstudiante(){
        return estudiante;
    }
    
    
   
    public List<Estudiante> leerEstudiante() throws IOException {
        String contenido=this.leer(directorio, "estudiantes.json");
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        //Transformar Lista
        Type listType=new TypeToken<ArrayList<Estudiante>>(){}.getType();
        estudiante=gson.fromJson(contenido, listType);
        return estudiante;
    }
    
    public void archivar() throws IOException{
        this.escribir(directorio, "estudiantes", estudiante);
    }
}

    

