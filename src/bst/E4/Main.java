/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/

public class Main {
    
    public static class Matriz {
        int filas;
        int columnas;
        int [][] matriz;

        public Matriz(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
            
            this.matriz = new int[filas][columnas];
        }

        public void setMatriz(int[][] matriz) {
            this.matriz = matriz;
        }
    }
    
    public static void main (String [] args) {
         Matriz A = new Matriz(2, 3);
         Matriz B = new Matriz(3, 5);
         Matriz C = new Matriz(5, 2);
         Matriz R;
         
         Matriz [] listaMatrices = new Matriz[3];
         listaMatrices[0] = A;
         listaMatrices[1] = B;
         listaMatrices[2] = C;
    }
    
}
