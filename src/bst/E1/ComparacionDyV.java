/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

public class ComparacionDyV {
    public static void main (String [] args) {
        double a = 5;
        double t1, t2, t3, t4;
        
        System.out.printf("%-5s %10s %10s \n", "n", "DyV", "FB");
        
        for (double n = 1; n <= 100; n++) { // Probaremos para varios valores de n
            t1 = System.nanoTime();
            exponenciacionDyV(a, n);
            t2 = System.nanoTime();
            
            t3 = System.nanoTime();
            exponenciacionFB(a, n);
            t4 = System.nanoTime();
            
            System.out.printf("%-5.0f %10.3f %10.3f \n", n, (t2-t1), (t4-t3));
        }
        
        System.out.println("(Tiempo en nanosegundos)");
    }
    
    public static double exponenciacionDyV (double a, double n) {
        
        if (n == 1) {
            return a;
        }
        
        if (n % 2 == 0) { // n es par y positivo
            return Math.pow(exponenciacionDyV(a, n/2), 2);
        }
        
        // n es impar y mayor a 1
        return Math.pow(exponenciacionDyV(a, (n-1)/2) , 2) * a;
    }
    
    public static double exponenciacionFB (double a, double n) {
        for (int i = 1; i < n; i++) {
            a = a * a;
        }
        return a;
    }
}
