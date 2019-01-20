package com.carlesramos.exetema08.exrcici07;

import com.carlesramos.exetema08.libreria.Lib;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CentroSalud {
    static Scanner lec = new Scanner(System.in);
    private Pacient [] registroPacientes = new Pacient[1240];
    private int contadorPacientes;
    private int eleccionMenu;
    public CentroSalud(){
        contadorPacientes = 0;
        do{
            visualizarMenu();
            eleccionMenu = lec.nextInt();
            lec.nextLine();
            if(eleccionMenu<0 || eleccionMenu>4){
                Lib.mensajeError();
            }
            switch(eleccionMenu){
                case 0:
                    Lib.mensajeSalida();
                    break;
                case 1:
                    nuevoPaciente();
                    break;
            }
        }while(eleccionMenu!=0);
    }

    public void nuevoPaciente(){
        String sip;
        String nombre;
        String sexe;
        int edat;
        Calendar dataEntrada;
        boolean estaAtendido = false;
        boolean sexeCorrecte = true;
        do {
            System.out.print("Introduce el Sip: ");
            sip = lec.nextLine();
            if(sip.length() != 7){
                Lib.mensajeError();
            }
            else if(sip.length() == 7) {
                for (int i = 0; i < contadorPacientes; i++) {
                    if (registroPacientes[contadorPacientes].getSip().equals(sip)
                            && registroPacientes[i].getDataAlta() != null) {
                        System.out.println(Lib.letraRoja() + "El paciente ya esta en la consulta..."
                                + Lib.reiniciarColor());
                        Lib.continuar();
                        estaAtendido = true;
                    }
                }
            }
        }while(sip.length() !=7 || estaAtendido);
        System.out.print("Introduce el nombre: ");
        nombre = lec.nextLine();
        do {
            System.out.print("Introduce el sexo \"M\" para masculino, \"F\" para femenino: ");
            sexe = lec.nextLine();
            if(sexe.equalsIgnoreCase("m") || sexe.equalsIgnoreCase("f")){
                sexeCorrecte = true;
            }
            else{
                Lib.mensajeError();
                sexeCorrecte=false;
            }
        }while (!sexeCorrecte);
        do {
            System.out.print("Introduzca la edad: ");
            edat = lec.nextInt();
            lec.nextLine();
            if(edat<0 || edat>120){
                Lib.mensajeError();
            }
        }while (edat<0 || edat>120);
        dataEntrada = Calendar.getInstance();

    }

    public void visualizarMenu(){
        System.out.println("*********************");
        System.out.println("**    URGENCIAS    **");
        System.out.println("*********************");
        System.out.println("1. Nuevo paciente ...");
        System.out.println("2. Atender paciente ...");
        System.out.println("3. Consultas ...");
        System.out.println("4. Alta médica ...");
        System.out.println("---------------------");
        System.out.println("0. Salir");
        System.out.print("Elija una opcion: ");
    }
}
