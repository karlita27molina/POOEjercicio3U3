package BEU;

import Molina.Persona;
import Molina.Unidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {

    private String numeroM;
    private Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private List<Calificacion> calificaciones = new ArrayList<>();
    private float promedio;  //informacion va a mostrar los datos que se van a procesar

    public Matricula() {
        fecha = Calendar.getInstance();
        estado = Estado.Registrada;
        UUID numero= UUID.randomUUID();
        this.numeroM=numero.toString();
    }

    public String getNumeroM() {
        return numeroM;
    }

    public void setNumeroM(String numeroM) {
        this.numeroM = numeroM;
    }



    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void calcularPromedio() {
        if (this.calificaciones.isEmpty()) {
            return;
        }
        float suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.valor; //se puede acceder al atributo porque es una clase interna
        }
        int divisor = this.calificaciones.size();
        promedio = (float) suma / (float) divisor;
        if (divisor == 3) {
            if (promedio > 14) {
                this.estado = Estado.Aprobada;
            } else {
                this.estado = Estado.Reprobada;
            }
        }
    }

    //Este metodo registra una calificacion y retorna un numero
    //1 si es nota de la Unidad I
    //2 si es nota de la Unidad II
    //3 si es nota de la Unidad III
    //0 si YA TIENE TODAS LAS NOTAS
    public int addCalificacion(float v) {  //se puede crear el objeto porque es una clase interna
        Calificacion cal = new Calificacion();
        int cuentasNotas = this.calificaciones.size();
        switch (cuentasNotas) {
            case 0:
                cal.setUnidad(Unidades.I);
                break;
            case 1:
                cal.setUnidad(Unidades.II);
                break;
            case 2:
                cal.setUnidad(Unidades.III);
                break;
            default:
                return 0;  //En caso de tener todas las notas retorna 0
        }
        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.calcularPromedio();
        return this.calificaciones.size(); //retorna rel tamaño de la lista

    }

    class Calificacion {

        private Calendar fecha;
        private float valor;
        private Unidades unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidades getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidades unidad) {
            this.unidad = unidad;
        }
    }

    @Override
    public String toString() {
        return estudiante.toString() + " N° Matricula: " + numeroM;
    }

    public String imprimirDetalle() {
        String str = "";
        str = "\n\t" + this.estudiante;
        for (Calificacion c : this.calificaciones) {
            str += "\t\t" + c.getValor();
        }
        str += "\t\t" + this.promedio + "\n";
        return str;
    }
}
