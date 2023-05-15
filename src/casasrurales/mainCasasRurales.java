/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casasrurales;

import java.util.InputMismatchException;
import java.util.Scanner;





/**
 *
 * @author Gonza
 */
public class mainCasasRurales {
    public static void pause(){
    System.out.println("");
    System.out.println("================================");
    System.out.println("Presione una tecla para continuar...");
    new java.util.Scanner(System.in).nextLine();
  }
    
    public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String poblacion;
        int numHabitacion;
        String direccion;
        double precio;
        int codigo;
        Scanner Leer = new Scanner(System.in);
        String opcion;
        int clave;
        Tabla tablaDispersa= new Tabla();
        boolean hayCasa=false;
        
        
    
        do {
            clear();
            System.out.println("----- MENÚ -----");
            System.out.println("1. Cargar");
            System.out.println("2. Lista de casas");
            System.out.println("3.Buscar");
            System.out.println("4. Dar de alta");
            System.out.println("5. Dar de baja");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = Leer.nextLine();
           
            switch (opcion) {
                case "1":
                    clear();
                    try{
                    System.out.println("Ingrese la direccion de la casa:");
                    System.out.print("->");
                    direccion = Leer.nextLine();
                    System.out.println("Ingrese quienes habitan en la casa:");
                    System.out.print("->");
                    poblacion = Leer.nextLine();
                    System.out.println("Ingrese la cantidad de habitaciones;");
                    System.out.print("->");
                    numHabitacion = Leer.nextInt();
                    Leer.nextLine();
                    while (numHabitacion<0){
                        System.out.print("Ingrese un numero valido:");
                        System.out.print("->");
                        numHabitacion = Leer.nextInt();
                        Leer.nextLine();
                    
                    }
                    System.out.println("Ingrese el precio de la casa:");
                    System.out.print("->");
                    precio = Leer.nextDouble();
                    Leer.nextLine();
                    while (precio<0){
                        System.out.print("Ingrese un precio valido:");
                        System.out.print("->");
                        precio = Leer.nextDouble();
                        Leer.nextLine();
                    
                    }
                    System.out.println("Ingrese el codigo de la casa de 5 caracteres:");
                    
                    System.out.print("->");
                    codigo = Leer.nextInt();
                    Leer.nextLine();
                    while (codigo<10000 || codigo>99999){
                    System.out.println("Ingrese un numero de 5 caracteres:");
                    System.out.print("->");
                    codigo = Leer.nextInt();
                    Leer.nextLine();
                    }
                    casaRurales casa=new casaRurales(poblacion, numHabitacion, direccion, precio, codigo);
                    tablaDispersa.insertModular(casa);
                    hayCasa=true;}
                    
                    catch (InputMismatchException e){
                    System.out.println("Dato mal ingresado");
                    Leer.nextLine();
                    }
                    
                    break;
                case "2":
                    clear();
                    if(hayCasa){
                        int i;
                        System.out.println("-----LISTA------");
                    for(i=0; i<tablaDispersa.aTamaño(); i++){
                        
                        casaRurales lista= tablaDispersa.lista(i);
                        if (lista!=null){
                           System.out.print("Direccion:" +lista.getDireccion());
                           System.out.println("/ codigo:" +lista.getCodigo());
                           System.out.println("--------------------------");
                    }
                    }
                    }else{
                    System.out.println("No se han cargado casas");
                    }
                    pause();
                    break;
                case "3":
                    clear();
                    if(hayCasa){
                        try{
                        System.out.println("Ingrese el codigo de la casa a buscar");
                        System.out.print("->");
                        codigo = Leer.nextInt();
                        Leer.nextLine();
                        
                        casaRurales buscarCasa= tablaDispersa.buscar(codigo);
                        
                        if (buscarCasa != null){
                           System.out.println("Direccion: " +buscarCasa.getDireccion());
                           System.out.println("Numero de habitaciones: " +buscarCasa.getNumHabitacion());
                           System.out.println("Numero de personas que la habitan: " +buscarCasa.getPoblacion());
                           System.out.println("Valor de la casa: $" +buscarCasa.getPrecio());
                           System.out.println("Codigo: " +buscarCasa.getCodigo());
                           if (buscarCasa.getEsAlta()){
                           System.out.println("Casa: HABILITADA");
                           }else{
                           System.out.println("casa: DESHABILITADA");
                           }                        
                        }else{
                        System.out.println("No se encontro la casa");
                        }}
                        catch (InputMismatchException e){
                    System.out.println("Dato mal ingresado");
                    Leer.nextLine();
                     }
                        
                    }else{
                        System.out.println("No se han cargado casas");}
                pause();

                    break;
                case "4":
                    clear();
                    try{
                    System.out.println("Ingrese el codigo de la casa que desee dar de alta");
                    System.out.print("->");
                        codigo = Leer.nextInt();
                        Leer.nextLine();
                        
                        casaRurales buscarCasa= tablaDispersa.buscar(codigo);
                        
                        if (buscarCasa != null){
                            boolean deAlta= true;
                            buscarCasa.setEsAlta(deAlta);
                         System.out.println("Su casa fue dada de alta");
                        }else{
                            System.out.println("No se encontro la casa");
                        }}
                    catch (InputMismatchException e){
                    System.out.println("Dato mal ingresado");
                    Leer.nextLine();
                    }
                     pause();

                    break;
                case "5":
                    clear();
                    try{
                      System.out.println("Ingrese el codigo de la casa que desee dar de baja");
                      System.out.print("->");
                        codigo = Leer.nextInt();
                        Leer.nextLine();
                        
                        casaRurales buscarCasa= tablaDispersa.buscar(codigo);
                        
                        if (buscarCasa != null){
                            boolean deAlta= false;
                            buscarCasa.setEsAlta(deAlta);
                         System.out.println("Su casa fue dada de baja");
                        }else{
                            System.out.println("No se encontro la casa");
                        }}
                    catch (InputMismatchException e){
                    System.out.println("Dato mal ingresado");
                    Leer.nextLine();
                    }
                    pause();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    pause();
                    break;
            }
        } while (!"6".equals(opcion));}
            }

        

    
    

