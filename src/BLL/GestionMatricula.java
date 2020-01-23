package BLL;

import BEU.Curso;
import BEU.Estado;
import BEU.Estudiante;
import BEU.Matricula;
import Molina.BaseBLLCrud;
import Molina.BasePersistencia;
import Molina.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionMatricula extends BasePersistencia<Matricula> implements BaseBLLCrud<Matricula> {

    private Matricula matricula;
    private final String directorio = "matriculas";

    public GestionMatricula() {
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String imprimirDetalle() {
        return this.matricula.toString();
    }

    public String calificar(float valor) {
        String mensaje = "";
        int num = this.matricula.addCalificacion(valor);
        switch (num) {
            case 0:
                mensaje = "\tTodas las notas están registradas";
                break;
            case 1:
                mensaje = "\tCalificacion de la nota Unidad I agregada correctamente";
                break;
            case 2:
                mensaje = "\tCalificacion de la nota Unidad II agregada correctamente";
                break;
            case 3:
                mensaje = "\tCalificacion de la nota Unidad III agregada correctamente";
                break;
            default:
                mensaje = "\tHubo un error al ingresar la nota";
                break;
        }
        return mensaje;
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ");
        sb.append(matricula.getEstudiante());
        sb.append("\nCurso: ");
        sb.append(matricula.getCurso().getTitulo());
        sb.append("\nPromedio: ");
        sb.append(matricula.getPromedio());
        return sb.toString();

    }

    public void anularMatricula(boolean opcion) {
        if (opcion == true) {
            matricula.setEstado(Estado.Anulada);
            float valorRubro = (matricula.getCurso().getCosto() * 10f) / 100;
            Util.imprimir("\n\tSu matricula a sido anulada exitosamente\n\tValor de Rubro por anulacion de matricula es: " + valorRubro);
        } else {
            Util.imprimir("\n\tSu matricula no ha sido anulada");
        }
    }

    public void archivar() throws IOException {
        this.escribir(directorio, this.matricula.getNumeroM(), matricula);
    }

    public void configurar(Curso cr, Estudiante est) {
        this.matricula.setCurso(cr);
        this.matricula.setEstudiante(est);
    }
    
    public List<Matricula> reportar(String titulo) throws IOException{
        List<Matricula> resultado=new ArrayList<>();
        List<String> contenidos=this.leerDirectorio(directorio,titulo);
        for(String texto: contenidos){
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
           try{ 
               Matricula m= gson.fromJson(texto, Matricula.class);           
            resultado.add(m);           
           }catch(JsonSyntaxException ex){
               Util.imprimir("El texto no se pudo convertir en texto"+ex.toString());
           }}
        return resultado;
    }

    @Override
    public void crear() {
        matricula = new Matricula();
    }
    

    @Override
    public void consultar(String id) throws IOException {
        String archivo = id + ".json";
        String contenido=this.leer(directorio, archivo);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido, Matricula.class);
    }

    @Override
    public void actualizar(Matricula objeto) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Matricula objeto) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
