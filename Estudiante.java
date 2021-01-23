/**
 * Un objeto de esta clase guarda la informaci�n de un estudiante
 *
 */
import java.util.*;
import java.lang.String;
public class Estudiante {

    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;

    /**
     *  
     *  Inicializa los atributos a partir de la informaci�n recibida
     *  Esta informaci�n se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
        String[] nuevaLinea = lineaDatos.split(" ");
        this.nombre = nombreCompuesto(nuevaLinea[0]);
        this.apellidos = nuevaLinea[1].trim().toUpperCase();
        this.faltasNoJustificadas = Integer.parseInt(nuevaLinea[2].trim());
        this.faltasJustificadas = Integer.parseInt(nuevaLinea[3]);

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
     * accesor para el n� de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el n� de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el n� de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el n� de faltas justificadas
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
     * Representaci�n textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        String faltas = "";
        if(this.faltasNoJustificadas == 0){
                faltas += "no hay faltas";
        }else if(this.faltasNoJustificadas >= 30){
            faltas += "10 20 30";
        }else if(this.faltasNoJustificadas >= 20){
            faltas += "10 20";
        }else if (this.faltasNoJustificadas >= 10){
            faltas += "10";
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
                " pedro jos�   andr�s  ,  Troya Baztarrica , 42, 6 ");
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
