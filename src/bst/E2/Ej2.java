/*
    Grupo g20:  Diego Ramon Noguera Areco
                Ricardo Sebastian Toledo Barrios
*/
import java.math.BigInteger;

public class Ej2 {
    
    //Funcion que multiplica iterativamente
    public static BigInteger multiplicarIterativo(BigInteger x, BigInteger y){
        //Se crea el acumulador, el contador y un "1"
        BigInteger r = new BigInteger("0"), i = new BigInteger("0"), p = new BigInteger("1");

        //Se efectua la multiplicacion iterativa
        while(i.compareTo(y) < 0 ){
            r = r.add(x);
            i = i.add(p);
        }
        
        return r;//retornamos el resultado final
    }

    //Funcion que multiplica recursivamente
    public static BigInteger multiplicarRecursivo(BigInteger x, BigInteger y, Integer n){
        //Caso base
        if(n <= 2){
            //BigInteger a int
            int a = x.intValue(), b = y.intValue(), c = 0;
            //multiplicacion iterativa
            for(Integer i = 0; i < b; i++ )
                c += a;

            //crea y devuelve el BigInteger
            return new BigInteger(String.valueOf(c));
        }
        else{
            //'10^n' y '10^n/2' como cadena para poder pasar a BigInteger 
            String s = "1", t = "1";
            for(Integer i = 0; i < n; i++){
                s += "0";
                if(i < n/2)
                    t += "0";

            }

            //Se separan los numeros en terminos altos y bajos
            //xp[0], yp[0] = terminos altos
            BigInteger [] xp = x.divideAndRemainder(new BigInteger(s));
             //xp[1], yp[1] = terminos bajos
            BigInteger [] yp = y.divideAndRemainder(new BigInteger(s));
            
            
            //Variables auxiliares de tipo big integer para las operaciones
            BigInteger j, k, l;

            //Se efectuan las operaciones y llamadas recursivas
            j = multiplicarRecursivo(xp[0], yp[0], n/2);
            j = j.multiply(new BigInteger(s));
            k = xp[0].subtract(xp[1]);
            l = yp[1].subtract(yp[0]);
            k = multiplicarRecursivo(k, l, n/2);
            l = multiplicarRecursivo(xp[0], yp[0], n/2);
            k = k.add(l);
            l = multiplicarRecursivo(xp[1], yp[1], n/2);
            k = k.add(l);
            k = k.multiply(new BigInteger(t));
            j = j.add(k);
            k = multiplicarRecursivo(xp[1], yp[1], n/2);
            j = j.add(k);

            //devolvemos el resultado final que se mostrara en pantalla
            return j;
            
        }
    }

    public static void main(String[] args) {
        //Cramos los BigInteger
        BigInteger x , y, imprimir;
        
        //variables a usar y contadores
        int n, i, contador=1;
        String a, b;
        long inicio, fin, tiempototal;
        
        //ciclo donde evaluaremos en los distintos casos de prueba
        for(n = 3; n < 7; n++){
            i = 0;
            a = ""; 
            b = "";
            
            while(i < n){
                //usaremos numeros aleatorios
                a += String.valueOf((int)(Math.random()*10));//digitos altos
                b += String.valueOf((int)(Math.random()*10));//digitos bajos
                i++;
            }
            
            //definimos nuestras variables x e y
            x = new BigInteger(a);
            y = new BigInteger(b);
            
            //Lllamamos a la funcion y mostramos el resultado
            System.out.println("Caso de prueba numero: "+contador);
            
            inicio = System.nanoTime();
            
            
            imprimir = multiplicarRecursivo(x, y, n);
            
            fin = System.nanoTime();
            tiempototal = fin - inicio;
            
            System.out.println("Multiplicacion recursiva de: "+x+" * "+y+" = "+imprimir+" tomo un tiempo de "+tiempototal+" nanosegundos");
            
            
            
            inicio = System.nanoTime();
            
            
            imprimir = multiplicarIterativo(x, y);
            
            fin = System.nanoTime();
            tiempototal = fin - inicio;
            
            System.out.println("Multiplicacion iterativa de: "+x+" * "+y+" = "+imprimir+" tomo un tiempo de "+tiempototal+" nanosegundos");
            
            contador++;
            System.out.println("\n");
            
        }
        
    }
}
