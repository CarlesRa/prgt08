package com.carlesramos.exetema08.exrcici07;
import com.carlesramos.exetema08.libreria.Lib;
import java.util.Calendar;
import java.util.Scanner;

public class CentreSalud {
    private  static Scanner lec = new Scanner(System.in);
    private Pacient [] registroPacientes;
    private int [] preRev;
    private int contadorPacientes;
    private int eleccionMenu;
    public CentreSalud(){
        registroPacientes = new Pacient[1240];
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
                case 2:
                    atenderPaciente();
                    break;
                case 3:
                    break;
            }
        }while(eleccionMenu!=0);
    }

    public void nuevoPaciente(){
        String sip;
        String nombre;
        String sexe;
        int edat;
        String sintomes;
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
                                + Lib.reiniciarColorLetra());
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

        System.out.print("Introduzca el motivo de la consulta: ");
        sintomes = lec.nextLine();
        dataEntrada = Calendar.getInstance();
        Pacient pacientAux = new Pacient(sip, nombre, sexe, edat, sintomes, dataEntrada);
        registroPacientes[contadorPacientes] = pacientAux;
        contadorPacientes++;
    }

    public void atenderPaciente(){
        preRev = new int[4];
        int temperatura;
        int pulsaPerMin;
        int tensioSistolica;
        int tensioDiastolica;
        String sip;
        System.out.print("Introduce el Sip del paciente a atender: ");
        sip = lec.nextLine();
        for(int i=0; i<contadorPacientes; i++){
            if (registroPacientes[i].getSip()==sip && registroPacientes[i].getDataAlta()==null){
                registroPacientes[i].toString();
                System.out.print("Temperatura: ");
                temperatura = lec.nextInt();
                lec.nextLine();
                System.out.print("Pulsaciones por minuto: ");
                pulsaPerMin = lec.nextInt();
                lec.nextLine();
                System.out.print("Tensión sistólica: ");
                tensioSistolica = lec.nextInt();
                lec.nextLine();
                System.out.print("Tensión diastólica: ");
                tensioDiastolica = lec.nextInt();
                lec.nextLine();
                preRev[0]=temperatura;
                preRev[1]=pulsaPerMin;
                preRev[2]=tensioSistolica;
                preRev[3]=tensioDiastolica;
                registroPacientes[i].setPreRev(preRev);
            }
        }
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
