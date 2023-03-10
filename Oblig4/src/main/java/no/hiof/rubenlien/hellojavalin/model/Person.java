package no.hiof.rubenlien.hellojavalin.model;

public class Person {
    private String forNavn;
    private String etterNavn;




    public Person(String forNavn, String etterNavn){
        this.forNavn = forNavn;
        this.etterNavn = etterNavn;
    }

    public String getNavn(){

        return this.forNavn + this.etterNavn;
    }

    @Override
    public String toString() {

        return forNavn + etterNavn;

    }

}

