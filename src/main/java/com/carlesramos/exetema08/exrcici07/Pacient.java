package com.carlesramos.exetema08.exrcici07;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Pacient {
    private String sip;
    private String nom;
    private String sexe;
    private int edat;
    private GregorianCalendar dataEntrada;
    private String sintomes;
    private float [] preRev;
    private String dataAlta;
    private String horaAlta;
    private String motiuAlta;

    public Pacient(String sip, String nom, String sexe, int edat, String sintomes, GregorianCalendar dataEntrada){
        this.sip = sip;
        this.nom = nom;
        this.sexe = sexe;
        this.edat = edat;
        this.dataEntrada = dataEntrada;
        this.sintomes = sintomes;

    }

    public Pacient(float [] preRev){
        this.preRev = preRev;
    }

    public Pacient() {
        sip = "";
        nom = "";
        sexe = "";
        edat = 0;
        dataEntrada = new GregorianCalendar();
        sintomes = "";
        preRev = new float [4];
        dataAlta = "";
        horaAlta = "";
        motiuAlta = "";
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(GregorianCalendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getSintomes() {
        return sintomes;
    }

    public void setSintomes(String sintomes) {
        this.sintomes = sintomes;
    }

    public float [] getPreRev() {
        return preRev;
    }

    public void setPreRev(float[] preRev) {
        this.preRev = preRev;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getHoraAlta() {
        return horaAlta;
    }

    public void setHoraAlta(String horaAlta) {
        this.horaAlta = horaAlta;
    }

    public String getMotiuAlta() {
        return motiuAlta;
    }

    public void setMotiuAlta(String motiuAlta) {
        this.motiuAlta = motiuAlta;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStr = sdf.format(dataEntrada.getTime());
        int dia = dataEntrada.get(Calendar.DAY_OF_WEEK);
        int mes = dataEntrada.get(Calendar.MONTH)+1;
        int any = dataEntrada.get(Calendar.YEAR);
        String data = dia+"-"+mes+"-"+any;
        int hora = dataEntrada.get(Calendar.HOUR_OF_DAY);
        int minuts = dataEntrada.get(Calendar.MINUTE);
        int segons = dataEntrada.get(Calendar.SECOND);
        String horaEntrada = hora+":"+minuts+":"+segons;
        return  String.format("%-9s%-9s%3s%15s%16s%19s%12s%8s%7s%10s%12s%15s%15s\n"
                ,sip,nom,sexe,fechaStr,horaEntrada,sintomes,preRev[0],preRev[1],preRev[2]
                ,preRev[3],dataAlta,horaAlta,motiuAlta);
    }
    public void mostrarPaciente(){
        int dia = dataEntrada.get(Calendar.DAY_OF_WEEK);
        int mes = dataEntrada.get(Calendar.MONTH)+1;
        int any = dataEntrada.get(Calendar.YEAR);
        String data = dia+"-"+mes+"-"+any;
        int hora = dataEntrada.get(Calendar.HOUR_OF_DAY);
        int minuts = dataEntrada.get(Calendar.MINUTE);
        int segons = dataEntrada.get(Calendar.SECOND);
        String horaEntrada = hora+":"+minuts+":"+segons;
        System.out.printf("%-9s%-9s%3s%15s%16s%20s\n"
                ,sip,nom,sexe,data,horaEntrada,sintomes);

    }
}

