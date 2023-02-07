/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

public class Main {
    public static void main (String [] args) {
        // enteros mayores a cero
        double a = 3;
        double n = 2;
        
        System.out.println(a + " elevado a " + n + " = " + exponenciacion(a, n));
        
        a = 2;
        n = 3;
        System.out.println(a + " elevado a " + n + " = " + exponenciacion(a, n));
        
        a = 24;
        n = 3;
        System.out.println(a + " elevado a " + n + " = " + exponenciacion(a, n));
    }
    
    public static double exponenciacion (double a, double n) {
        
        // 1
        if (n == 1) {
            return a;
        }

        // n/2
        if (n % 2 == 0) { // n es par y positivo
            return Math.pow(exponenciacion(a, n/2), 2);
        }
        
        // (n-1/2)
        // n es impar y mayor a 1
        return exponenciacion(exponenciacion(a, (n-1)/2) , 2) * a;
        
        // T(n) = n/2 + (n-1)/2 + 1
        // T(n) = n/2 + n/2 -1/2 + 1
        // T(n) = 2T(n/2) + c
        // O(n) por teorema del maestro
    }
}
