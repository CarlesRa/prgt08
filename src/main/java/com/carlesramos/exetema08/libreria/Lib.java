package com.carlesramos.exetema08.libreria;
import  java.util.Scanner;

public class Lib{
    static  Scanner lec = new Scanner (System.in);
    public static  String limpiarPantalla(){
        return "\u001B[H\u001B[2J";
    }

    public static String letraRoja(){
        return "\u001B[31m";
    }

    public static  String reiniciarColor(){
        return "\u001B[0m";
    }

    public  static void mensajeError(){

        System.out.print(limpiarPantalla()+letraRoja()+
                "Dato erroneo, pulsa intro para continuar: "+reiniciarColor());
        lec.nextLine();
    }

    public static void mensajeSalida(){
        System.out.print("Saliendo de la aplicación, pulsa intro para continuar: ");

        lec.nextLine();
    }

    public static  void continuar(){
        System.out.println("Pulsa intro para continuar: ");
        lec.nextLine();
    }
}