package no.hiof.rubenlien.hellojavalin.model;

import java.util.ArrayList;

public class Rolle {
    private String rolleFornavn;
    private String rolleEtternavn;
    private Person skuespiller;



    public Rolle(String rolleFornavn, String rolleEtternavn, Person skuespiller) {
        this.rolleFornavn = rolleFornavn;
        this.rolleEtternavn = rolleEtternavn;
        this.skuespiller = skuespiller;

    }

    @Override
    public String toString() {

        return "Skuespilleren heter " + skuespiller + " og navnet på rollen er" + rolleFornavn + rolleEtternavn;

    }


}



