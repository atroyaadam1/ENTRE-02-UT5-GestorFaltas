/**
 * Punto de entrada a la aplicaci�n
 *  * @author - Anthonny Troya
 */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el n� m�ximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la informaci�n solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Error en argumentos");
            System.out.println("Sintaxis: java TestGestorFaltas <max_estudiantes>");
        }
        else{
            int aux = Integer.parseInt(args[0]);
            GestorFaltas gestor = new GestorFaltas(aux);
            gestor.leerDeFichero();
            gestor.justificarFaltas("IRISO FLAMARIQUE", 6);
            gestor.ordenar();
            System.out.println("Se muestra el curso ordenado por faltas injustificadas\n");
            System.out.println(gestor.toString());
            gestor.anularMatricula();
            System.out.println("Despu�s de anular matr�cula\n");
            System.out.println(gestor.toString());
        }
    } 
}

