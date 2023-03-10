package no.hiof.rubenlien.hellojavalin.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Produksjon {
    private String tittel;
    private int spilletid;
    private LocalDate utgivelsesDato;
    private String beskrivelse;
    private Person regissor;
    private ArrayList<Rolle> roller;
    private String bildeUrl;


    public Produksjon(){

    }

    public void leggTilEnRolle(Rolle enRolle) {
     roller.add(enRolle);

    }

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
      roller.addAll(flereRoller);

    }


    public Produksjon(String tittel, int spilletid, LocalDate utgivelsesDato, String beskrivelse, String bildeUrl ) {
        this.tittel = tittel;
        this.spilletid = spilletid;
        this.utgivelsesDato = utgivelsesDato;
        this.beskrivelse = beskrivelse;
        this.bildeUrl = bildeUrl;
        roller = new ArrayList<>();

    }





    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }


    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesDato() {
        return utgivelsesDato;
    }

    public void setUtgivelsesDato(LocalDate utgivelsesDato) {
        this.utgivelsesDato = utgivelsesDato;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    public void setBildeUrl() {
        this.bildeUrl = bildeUrl;
    }


    public Person getRegissor() {
        return this.regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public ArrayList<Rolle> getRoller() {
        return new ArrayList<>(roller);
    }



}

