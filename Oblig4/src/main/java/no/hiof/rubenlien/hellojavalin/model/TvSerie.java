package no.hiof.rubenlien.hellojavalin.model;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerie implements Comparable<Episode>{
    private String tittel, beskrivelse;
    private LocalDate utgivelsesDato;
    private ArrayList<Episode> episoder;
    private String bildeUrl;
    private int gjennomsnittligSpilletid, antallSesonger;

    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesDato, String bildeUrl) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesDato = utgivelsesDato;
        this.bildeUrl = bildeUrl;
        episoder = new ArrayList<>();
    }
;
    public void leggTilEpisode(Episode episode) {
        if (antallSesonger+1 < episode.getSesongNr()) {
            System.out.println("FEIL: Episoden \"" + episode + "\" kan ikke være høyere enn sesong: " + (antallSesonger+1));
        }
        else {
            episoder.add(episode);
            oppdaterGjennomsnittligSpilletid();

            if (antallSesonger < episode.getSesongNr()) {
                antallSesonger++;
            }
        }
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int sum = 0;

        for (Episode episode : episoder) {
            sum += episode.getSpilletid();
        }

        gjennomsnittligSpilletid = sum / episoder.size();
    }

    public ArrayList<Episode> hentEpisoderISesong(int sesong) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode episode : episoder) {
            if (episode.getSesongNr() == sesong)
                episoderISesong.add(episode);
        }

        return episoderISesong;
    }

    public ArrayList<Rolle> hentRollebesetning(){

        ArrayList<Rolle> rollebesetning = new ArrayList<>();

        // Går gjennom hver enkelt episode i episodelisten
        for (Episode enEpisode : episoder) {
            // Går gjennom hver enkelt rolle som er listet opp i en episode
            for (Rolle enRolle : enEpisode.getRoller()) {
                // Undersøker om vi har lagt til akkurat denne rollen i listen før
                if (!rollebesetning.contains(enRolle))
                    // Hvis vi ikke har det, legger vi den til i lista
                    rollebesetning.add(enRolle);
            }
        }

        return rollebesetning;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
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

    public int getAntallSesonger() { return antallSesonger;}

    public void setUtgivelsesDato(LocalDate utgivelsesDato) {
        this.utgivelsesDato = utgivelsesDato;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    public void setBildeUrl(String bildeUrl) {
        this.bildeUrl = bildeUrl;
    }

    /**
     * Henter en liste med alle episodene for TvSerien
     * @return Liste med alle episodene
     */
    public ArrayList<Episode> getEpisoder() {
        // Vi lager en kopi av listen vi har, slik at den interne listen ikke kan manipuleres direkte utenfor klassen (innkapsling)
        return new ArrayList<>(episoder);
    }

    public int getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    @Override
    public String toString() {
        return tittel +" - " + utgivelsesDato.getYear();
    }

    @Override
    public int compareTo(Episode o) {

        return 0;
    }
}
