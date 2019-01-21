package com.carlesramos.exetema08.exrcici07;
import com.carlesramos.exetema08.libreria.Lib;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CentreSalud {
    private  static Scanner lec = new Scanner(System.in);
    private Pacient [] registroPacientes;
    private float [] preRev;
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
                    consultas();
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
        GregorianCalendar dataEntrada;
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
        dataEntrada = new GregorianCalendar();
        String.format("dd,mm,aaaa,hh:mm:ss",dataEntrada.getTime());
        Pacient pacientAux = new Pacient(sip, nombre, sexe, edat, sintomes, dataEntrada);
        registroPacientes[contadorPacientes] = pacientAux;
        contadorPacientes++;
    }

    public void atenderPaciente(){
        preRev = new float[4];
        int temperatura;
        int pulsaPerMin;
        int tensioSistolica;
        int tensioDiastolica;
        String sip;
        System.out.print("Introduce el Sip del paciente a atender: ");
        sip = lec.nextLine();
        for(int x=0; x<contadorPacientes; x++){
            if (registroPacientes[x].getSip().equals(sip)){
                cabecera();
                registroPacientes[x].mostrarPaciente();
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
                registroPacientes[x].setPreRev(preRev);
            }
        }
    }

    public void consultas(){
        String sip;
        int opcion;
        do{
            menuConsultas();
            opcion = lec.nextInt();
            lec.nextLine();
            switch (opcion){
                case 1:
                    do {
                        System.out.print("Introduce el Sip: ");
                        sip = lec.nextLine();
                        if (sip.length() != 7) {
                            Lib.mensajeError();
                        }
                    }while (sip.length()!=7);
                    cabecera();
                    for (int i=0; i<contadorPacientes; i++){
                        if(registroPacientes[i].getSip().equals(sip)){
                            if(registroPacientes[i].getPreRev()==null){
                                registroPacientes[i].mostrarPaciente();
                            }
                            else {
                                System.out.println(registroPacientes[i].toString());
                            }
                        }
                    }
                    Lib.continuar();
                    break;

            }
        }while (opcion!=0);

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

    public void menuConsultas(){
        System.out.println("********************************");
        System.out.println("**          CONSULTAS         **");
        System.out.println("*********************");
        System.out.println("1. Por Sip ...");
        System.out.println("2. Por fechas ...");
        System.out.println("3. Estadisticas ...");
        System.out.println("4. Mostrar histórico mensual ...");
        System.out.println("--------------------------------");
        System.out.println("0. Salir");
        System.out.print("Elija una opcion: ");
    }

    public void cabecera(){
        System.out.printf("%-11s%-10s%-7s%-10s%16s%20s%8s%6s%10s%11s%16s%14s%14s\n"
                ,"Sip","Nombre","Sexo","Fecha entrada","Hora entrada","Sintomatologia","Temp","ppm","Ten Sis"
                ,"Ten Dias","Fecha de alta","Hora de alta","Motivo alta");
    }
}
