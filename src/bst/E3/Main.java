/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

public class Main {
    
    public static void main(String[] args) throws Exception {
        int monto;
        int [] vuelto;
        int[] denominaciones = {2000, 5000, 10000, 20000, 50000, 100000};
        
        monto = 92000;
        vuelto = minimizarVuelto(monto, denominaciones);
        imprimirVuelto(vuelto, denominaciones, monto);
        
        monto = 15000;
        vuelto = minimizarVuelto(monto, denominaciones);
        imprimirVuelto(vuelto, denominaciones, monto);
        
        monto = 11000;
        vuelto = minimizarVuelto(monto, denominaciones);
        imprimirVuelto(vuelto, denominaciones, monto);
        
        // No siempre obtiene la solucion por que siempre que se pase a la 
        // siguiente denominacion menor de billetes ya no es posible retroceder
        // para tomar una denominacion mayor. Por ejemplo si el monto es 11000:
        // primero se toma el billete de mayor denominacion que se puede, en este
        // caso es 10000, luego sobra 1000 que ya no se puede completar por que
        // ya no existen denominaciones menores o iguales a 1000. Sin embargo una 
        // solucion valida para este caso es tomar un billete de 5000 y tres
        // billetes de 2000.
        
        // https://en.wikipedia.org/wiki/Change-making_problem
        
    }
    
    public static int[] minimizarVuelto(long monto, int[] denominaciones) throws Exception {
        int i = denominaciones.length - 1;
        int[] vuelto = new int[denominaciones.length];
        cerar(vuelto);
        while (monto > 0) {
            if (i < 0) {
                throw new Exception("No es posible devolver vuelto");
            }
            if (monto - denominaciones[i] >= 0) {
                vuelto[i]++;
                monto = monto - denominaciones[i];
            } else {
                i--;
            }
        }
        
        return vuelto;
    }
    
    public static void imprimirLista(int[] lista) {
        int n = lista.length;
        for (int i = 0; i < n; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println("");
    }
    
    public static void cerar(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = 0;
        }
    }
    
    public static void imprimirVuelto(int[] vuelto, int[] denominaciones, int monto) {
        System.out.println("Vuelto para " + monto);
        for (int i = 0; i < denominaciones.length; i++) {
            if (vuelto[i] != 0) {
                System.out.println(vuelto[i] + " billetes de " + denominaciones[i]);
            }
        }
        System.out.println("");
    }
}
