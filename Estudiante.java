/**
 * Un objeto de esta clase guarda la información de un estudiante
 * @author - Anthonny Troya
 * @version (version number or date here)
 */
import java.util.*;
import java.lang.String;
public class Estudiante {

    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;
    private Apercibimientos apercibimiento;
    /**
     *  
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
        String[] nuevaLista = lineaDatos.split(SEPARADOR);
        this.nombre = nombreCompuesto(nuevaLista[0]);
        this.apellidos = nuevaLista[1].toUpperCase();
        this.faltasNoJustificadas = Integer.parseInt(nuevaLista[2]);
        this.faltasJustificadas = Integer.parseInt(nuevaLista[3]);
    }

    /**
     * 
     */
    public String nombreCompuesto(String nombre) {
        String[] nombres = nombre.split(SEPARADOR);
        String nombreInicio = "";
        String nombreFinal ="";
        for ( int i = 0; i < nombres.length; i++){
                if (nombres[i] != " "){
                    nombreInicio += nombres[i].charAt(0);
                    nombreFinal += nombreInicio.toUpperCase() + SEPARADOR;
                }
            else if(i == (nombres.length - 1)){
                nombreInicio += nombres[i].charAt(0);
                nombreFinal += nombreInicio + nombres[i].substring(0);
            } 
        } 
        return nombreFinal;
    }

    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el nº de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el nº de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el nº de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el nº de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representación textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        String faltas = "";
        if(this.faltasNoJustificadas < 10){
                faltas += "sin apercibimientos";
        }else if(this.faltasNoJustificadas < 20){
            faltas += apercibimiento.DIEZ;
        }else if(this.faltasNoJustificadas < 30){
            faltas += apercibimiento.DIEZ + ""+apercibimiento.VEINTE;
        }else {
            faltas += apercibimiento.DIEZ + " "   + apercibimiento.VEINTE+ " " + apercibimiento.TREINTA;
        }
        String lista = apellidos + "," + nombre;
        String str = String.format("%-24s %-35s",
        "Apellidos y Nombre:",lista,"\nFaltas No Justificadas:", faltasNoJustificadas,
        "\nFaltas Justificadas:", faltasJustificadas, "\nfaltas:",faltas);
        return str;

    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai  ,  Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro josé   andrés  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}
