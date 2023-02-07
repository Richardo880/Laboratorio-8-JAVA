/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

// https://en.wikipedia.org/wiki/Change-making_problem
import java.util.ArrayList;
import java.util.List;

public class Mejorado {

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

    public static void main(String[] args) {
        int monto;
        int[] denominaciones = {100000, 50000, 20000, 10000, 5000, 2000};
        int[] vuelto = new int[denominaciones.length];
        cerar(vuelto);

        List<int[]> soluciones = new ArrayList<>();

        monto = 15000;
        minimizar(monto, monto, vuelto, denominaciones, soluciones, denominaciones.length-1);

        System.out.println("Denominaciones");
        imprimirLista(denominaciones);

        System.out.println("Cantidad de soluciones: " + soluciones.size());
        for (int i = 0; i < soluciones.size(); i++) {
            for (int j = 0; j < soluciones.get(i).length; j++) {
                System.out.print(soluciones.get(i)[j] + " ");
            }
            System.out.println("");
        }

    }

    public static void minimizar(int monto, int saldo, int[] vuelto, int[] denomicaciones, List<int[]> soluciones, int i) {
        if (esSolucion(monto, vuelto, denomicaciones)) {
            soluciones.add(vuelto);
            return;
        } else {
            if (i >= 0) {
                for (int j = 0; j <= monto / denomicaciones[0]; j++) {
                    vuelto[i]++;
                    saldo = saldo - denomicaciones[i];
                    minimizar(monto, saldo, vuelto, denomicaciones, soluciones, i-1);
                }  
            }
             
        }

    }

    public static boolean esSolucion(int monto, int[] vuelto, int[] denomicaciones) {
        int suma = 0;
        for (int i = 0; i < vuelto.length; i++) {
            suma = suma + denomicaciones[i] * vuelto[i];
        }

        return suma == monto;
    }
}
