/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author ricar
 */
/*
 * ALGORITMOS Y ESTRUCTURAS DE DATOS III - Seccion TQ - Prof. Cristian Cappo / Prof. Luis More
 * Ing. Informatica
 * 2021-1er Periodo
 *
 * Implementa la clase BST (Arbol Binario de Busqueda)
 * El dato cuya referencia se almacena en cada nodo
 * es un Comparable o derivado. 
 *
 * Esta implementaci�n no utiliza Generic !!
 * ---------------------------------------
 */

public class BST
{

   private class NodoBST { 
      Comparable dato = null;
	  NodoBST izq = null;
	  NodoBST der = null;

	  public NodoBST (Comparable dato)
     {
        this.dato = dato;
     }
   }
   
   private NodoBST raiz = null;


   /* Agregar un dato al arbol */ 
   public void agregar (Comparable dato)
   {
      raiz = priv_agregar (raiz, dato);
   }

   /*
    * Retorna el "nodo" donde se encuentra el primer dato
    * que dice ser igual a parametro dado.
    * La comparacion se realiza via "compareTo()" de la interfaz Comparable.
    */
   public Comparable buscar (Comparable dato)
   {
      NodoBST nodo = priv_buscar(raiz,dato);
	  if ( nodo != null ) 
	     return nodo.dato;
	  else { /* Reemplazar por manejo de excepcion!! */
	     System.out.println("No existe en el arbol!!! " + dato);
         return null;	  
	  }	 
   }

   /*
    * Imprime el arbol en recorrido infijo o simetrico.
    */
   public void imprimir()
   {
      System.out.println();
      priv_imprimir (raiz);
      System.out.println();
   }


   private NodoBST priv_agregar (NodoBST n_actual, Comparable dato)
   {
      if ( n_actual == null )
         return ( new NodoBST(dato) );

     int comparacion = dato.compareTo (n_actual.dato);
	 
	 if ( comparacion < 0 ) 
	 	n_actual.izq = priv_agregar(n_actual.izq,dato);
	 else
		n_actual.der = priv_agregar(n_actual.der,dato);
		 
	 return n_actual;
	 
   }


   /* Imprime en in-orden */
   private void priv_imprimir (NodoBST n_actual)
   {
      if ( n_actual != null )
      {
         priv_imprimir (n_actual.izq);
         System.out.print (n_actual.dato + " ");
         priv_imprimir (n_actual.der);
      }
   }


   private NodoBST priv_buscar (NodoBST n_actual, Comparable dato)
   {
      if ( n_actual == null )      // dato no se encuentra en el arbol
         return null;

     int comparacion = dato.compareTo (n_actual.dato);

	 if ( comparacion == 0 )      // dato == n_actual.dato 
	   return n_actual;
	 else if ( comparacion < 0 )  // dato < n_actual.dato, puede estar a la izquierda
	   return priv_buscar(n_actual.izq,dato);
     else	                      // dato > n_actual.dato, puede estar a la derecha
	   return priv_buscar(n_actual.der,dato);
	      
   }
   
   public int lci ()  {
	    return lci(raiz,0);
   }
   
   private int lci ( NodoBST nodo, int nivel) {
	    if ( nodo == null ) 
			return 0;
        else 
	        return nivel + lci(nodo.izq, nivel+1) + lci (nodo.der, nivel+1);
   }
   
   /*
     Un ejemplo de uso sencillo de uso de la clase BST
   */   
   public static void main ( String [] args ) {
      BST t = new BST();
	  Integer [] A = { 10,10,10, 15, 7, 8, 6, 2, 11, 12 };
	  for ( int k=0; k < A.length-1; k++ )
	    t.agregar( A[k]);
	
	  t.imprimir();
	  
 
       

	  Integer k = (Integer) t.buscar(81);
	  
	  if ( k != null ) 
	     System.out.println("Si existe!!" + k);
	  
   }
}