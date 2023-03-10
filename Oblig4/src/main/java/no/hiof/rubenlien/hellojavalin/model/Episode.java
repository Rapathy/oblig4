package no.hiof.rubenlien.hellojavalin.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Episode extends Produksjon implements Comparable<Episode>{
    private int episodeNummer, sesongNummer, spilletid;


    public Episode(int episodeNummer, int sesongNummer) {
        // Kaller den andre konstruktøren, sender parameterne videre, men setter spilletid til 0
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.spilletid = 0;

    }

    /**
     * Konstruktør for Episode
     *
     * @param tittel    - tittelen til episoden
     * @param episodeNummer - episodenummeret til episoden (i denne sesongen)
     * @param sesongNummer  - sesongnummeret til episoden
     * @param spilletid - spilletid i minutter
     */
    public Episode(String tittel, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesDato, String beskrivelse, String bildeUrl) {
        super(tittel, spilletid, utgivelsesDato, beskrivelse, bildeUrl);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.spilletid = spilletid;
    }

    public int getEpisodeNr() {
        return episodeNummer;
    }

    public void setEpisodeNr(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNr() {
        return sesongNummer;
    }

    public void setSesongNr(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }


    /**
     * Genererer en string for Episode
     * @return String i formen "NavnPåEpisode - S01E03 - Spilletid: 25"
     */
    @Override
    public String toString() {
        // String format legger her bare på 0 foran, slik at vi f.eks. får det på formatet 03 fremfor bare 3
        return super.getTittel() + " - S" + String.format("%02d", sesongNummer) + "E" + String.format("%02d", episodeNummer) + " - Spilletid: " + spilletid;
    }

    @Override
    public int compareTo(Episode annenListe) {
        int returverdi = (int) (this.spilletid - annenListe.spilletid);

        return returverdi;
    }
}
