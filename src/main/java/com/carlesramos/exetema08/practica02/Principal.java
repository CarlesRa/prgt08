package com.carlesramos.exetema08.practica02;
import com.carlesramos.exetema08.libreria.Lib;
import java.util.Arrays;
import java.util.Scanner;
public class Principal {
    private int eleccio;
    private Scanner lec;
    private MaquinaSortejos maquina;
    public Principal(){
        maquina = new MaquinaSortejos();
        lec = new Scanner(System.in);
        do {
            eleccio = mostrarMenu();
            switch (eleccio) {
                case 0:
                    break;
                case 1:
                    System.out.println(Arrays.toString(maquina.jocUnic()));
                    Lib.continuar();
                    break;
                case 2:
                    Lib.continuar();
                    break;
                case 3:
                    Lib.continuar();
                    break;
                case 4:
                    Lib.continuar();
                    break;
                case 5:
                    Lib.continuar();
                    break;
            }
        }while (eleccio != 0);
    }

    public int mostrarMenu() {
        int eleccio;
        do {
            System.out.println("******************************************************");
            System.out.println("**********************PRIMITIVA***********************");
            System.out.println("1-Joc unic...");
            System.out.println("2-Jugar fins a obtenir premi...");
            System.out.println("3-Jugar fins a obtenir premi (sense reintegrament)...");
            System.out.println("4-Cicle de 10.000 sortejos...");
            System.out.println("5-Jugar fins a obtenir premi de categoria especial...");
            System.out.println("*****************************************************");
            System.out.println("0-Eixir");
            System.out.print("Tria una opció: ");
            eleccio = lec.nextInt();
            lec.nextLine();
            return eleccio;
        } while (eleccio >= 0 || eleccio >= 5);
    }
}
