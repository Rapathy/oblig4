package no.hiof.rubenlien.hellojavalin.model;

import java.time.LocalDate;

public class Film extends Produksjon{
    public Film(String tittel, int spilletid, LocalDate utgivelsesDato, String beskrivelse,  String bildeUrl) {
        super(tittel, spilletid, utgivelsesDato, beskrivelse, bildeUrl );
    }




}
