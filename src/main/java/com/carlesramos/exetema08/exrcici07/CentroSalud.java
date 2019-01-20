package com.carlesramos.exetema08.exrcici07;

import java.util.Scanner;

public class CentroSalud {
    public CentroSalud(){
        int eleccioSwitch;
        eleccioSwitch=mostrarMenu();
    }
    public int mostrarMenu(){
        int eleccio;
        Scanner lec = new Scanner(System.in);
        do {
            do {
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
                eleccio = lec.nextInt();
                lec.nextLine();
                if(eleccio<0 || eleccio>4){
                    System.out.println("Dato erroneo....");
                    System.out.print("intro para continuar: ");
                    lec.nextLine();
                }
            } while (eleccio<0 || eleccio>4);
            return eleccio;
        }while (eleccio != 0);
    }
}
