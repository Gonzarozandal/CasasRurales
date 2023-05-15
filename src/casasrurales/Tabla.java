/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casasrurales;

/**
 *
 * @author Gonza
 */
public class Tabla {
     private casaRurales[] T;
     
     private int numElementos;
     private double factorCarga;
     private final int tamaño;
    
     //constructor de la tabla hash
     public Tabla(){
        int i;
        tamaño = 101;
        this.T=new casaRurales[tamaño];
        for (i=0; i<tamaño; i++){
        T[i]=null;
        numElementos=0;
        factorCarga=0.0;  
        }   
        
    }


     public int aTamaño(){
     return tamaño;
     }
     
     public int Modular (int x){
         int i = 0, p;
            long d;
            // aplica aritmética modular para obtener dirección base
            p = (int) (x % tamaño);
            // bucle de exploración
            while (T[p] != null && T[p].aCodigo()!=x) {
              i++;
              p = p + i * i;
              p = p %tamaño; // considera el array como circular
            } 
        return p;
    }
     
      public void insertModular(casaRurales e){
          numElementos++;
          factorCarga=(double)(numElementos) / tamaño;
          
        T[Modular(e.getCodigo())]=e;
        if (factorCarga > 0.5)
      System.out.println("\n!! Factor de carga supera el 50%.!!" + " Conviene aumentar el tamaño.");
       }
      
      public casaRurales lista(int x){
         casaRurales casa;
         int posicion;
         posicion=x;
         casa = T[posicion];
         
         return casa;
      }
      
       public casaRurales buscar(int x){
         casaRurales casa;
         int posicion;
         posicion=Modular(x);
         casa = T[posicion];
         return casa;
      }
      
        
    }

       
