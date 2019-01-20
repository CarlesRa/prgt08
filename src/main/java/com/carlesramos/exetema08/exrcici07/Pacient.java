package com.carlesramos.exetema08.exrcici07;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Pacient {
    private String sip;
    private String nom;
    private String sexe;
    private int edat;
    private Calendar dataEntrada;
    private String sintomes;
    private String [] preRev;
    private String dataAlta;
    private String horaAlta;
    private String motiuAlta;

    public Pacient(String sip, String nom, String sexe, int edat, String sintomes, Calendar dataEntrada){
        this.sip = sip;
        this.nom = nom;
        this.sexe = sexe;
        this.edat = edat;
        this.dataEntrada = dataEntrada;
        this.sintomes = sintomes;

    }

    public Pacient(String [] preRev){
        this.preRev = preRev;
    }

    public Pacient() {
        sip = "";
        nom = "";
        sexe = "";
        edat = 0;
        dataEntrada = new GregorianCalendar();
        sintomes = sintomes;
        preRev = new String [4];
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

    public String[] getPreRev() {
        return preRev;
    }

    public void setPreRev(String[] preRev) {
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
}

