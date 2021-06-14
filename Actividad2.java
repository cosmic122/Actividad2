import java.io.BufferedReader; // importación de librerías a utilizar
import java.io.InputStreamReader;

public class Actividad2 { // clase principal

    public static void main (String[] args)  // Se convierte el método main en un objeto llamado run, para que el método main pueda aceptar variables no-estáticas
    {
        try
        {
            Actividad2 obj = new Actividad2 ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }

    // inicialización de variables

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)); // declaración del BufferedReader

    double calificacion[] = new double[5]; // array para guardar las calificaciones introducidas
    double sum = 0; // variable para guardar la suma de las calificaciones introducidas
    double prom; // variable para guardar el promedio
    String cal; // variable para guardar la calificacion final
    String nombre; // variable para guardar el nombre del usuario

    // método run

    public void run (String[] args) throws Exception {


        System.out.println("Introduzca su nombre:"); // Se pide al usuario que introduzca su nombre
        nombre = entrada.readLine(); // espacio para que introduzca su nombre

        for (int i = 0; i < 5; i++) { // declaramos el valor de i en 0. el loop se repite hasta que i sea igual o mayor a 5. se aumenta i + 1 con cada repetición

            try { // manejo de excepciones

                System.out.println("Introduzca las calificacion de la materia " + (++i) + ": "); // se le pide al usuario que introduzca la calificacion de la materia con el valor de i + 1. El i++ se usa para elevar temporalmente el 0 a 1, 1 a 2, etc.
                calificacion[--i] = Integer.parseInt(entrada.readLine()); // espacio para introducir la calificacion. se guarda en --i porque en la linea anterior aumentamos temporalmente el valor de i y ahora lo regresamos para que entre en el espacio correcto dentro del array
                if (calificacion[i] > 100) { // manejo de error de usuario. si la calificacion guardada en el espacio con el numero indicado por la variable i, es mayor a 100
                    System.out.println("Calificación inválida, intente de nuevo."); // le decimos al usuario que el valor introducido es invalido y que intente de nuevo
                    i--; // restamos 1 del valor actual de i para regresar a la posición inicial
                    continue; // continúa el loop
                }

                sum = sum + calificacion[i]; // sumamos el valor de sum (inicialmente 0) con el valor introducido. esto se repite en cada loop, entonces nos permite sumar todos los valores al final de la ejecucion del loop

            }

            catch(Exception e) { // manejo de excepciones
                System.out.println("Por favor intente de nuevo.");
                i--;
            }

        }

        promedio(); // Llamar métodos

        calif();

        printOut();
    }



        public double promedio() { // método para calcular el promedio

            prom = sum / calificacion.length;
            return prom;

        }

        public String calif() { // método para definir la calificacion final

            if (prom <= 50) {
                cal = "F";
            }

            else if (prom > 50 && prom <=60){
                cal = "E";
            }

            else if (prom > 60 && prom <=70){
                cal = "D";
            }

            else if (prom > 70 && prom <=80){
                cal = "C";
            }

            else if (prom > 80 && prom <=90){
                cal = "B";
            }

            else if (prom > 90 && prom <=100){
                cal = "A";
            }

            return cal;
        }

        public void printOut() { // método para imprimir toda la información obtenida

            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Calificación 1: " + calificacion[0]);
            System.out.println("Calificación 2: " + calificacion[1]);
            System.out.println("Calificación 3: " + calificacion[2]);
            System.out.println("Calificación 4: " + calificacion[3]);
            System.out.println("Calificación 5: " + calificacion[4]);
            System.out.println("Promedio: " + prom);
            System.out.println("Calificación: " + cal);

        }

}
