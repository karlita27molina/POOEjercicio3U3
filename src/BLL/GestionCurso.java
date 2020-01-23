package BLL;

import BEU.Curso;
import Molina.BasePersistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestionCurso extends BasePersistencia<Curso> {

    private List<Curso> curso = new ArrayList();

    public GestionCurso() {               
    }

    public List<Curso> getCurso() throws IOException {
        String contenido=this.leer("cursos", "cursos.json"); GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        //Transformar Lista
        Type listType=new TypeToken<ArrayList<Curso>>(){}.getType();
        curso=gson.fromJson(contenido, listType);
        return curso;
    }
    
    //Crear archivo de la lista
    

}
