package com.carlesramos.exetema08.libreria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import  java.util.Scanner;

public class Lib{
    static  Scanner lec = new Scanner (System.in);
    public static  String limpiarPantalla(){
        return "\u001B[H\u001B[2J";
    }

    public static String letraRoja(){
        return "\u001B[31m";
    }

    public static  String reiniciarColorLetra(){
        return "\u001B[0m";
    }

    public  static void mensajeError(){

        System.out.print(limpiarPantalla()+letraRoja()+
                "Dato erroneo, pulsa intro para continuar: "+ reiniciarColorLetra());
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

    /**
     * Metode per validar dates.
     * @param fecha entra un string amb la data.
     * @return
     */
    public static boolean validarFecha(String fecha) {

        try {

            SimpleDateFormat formatoFecha;
            formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

            formatoFecha.setLenient(false);

            formatoFecha.parse(fecha);

        } catch (ParseException e) {

            return false;

        }

        return true;

    }
}