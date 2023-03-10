package no.hiof.rubenlien.hellojavalin.repository;

import no.hiof.rubenlien.hellojavalin.model.Episode;
import no.hiof.rubenlien.hellojavalin.model.TvSerie;

import java.util.ArrayList;

public interface TvSerieRepository {

    ArrayList<TvSerie> getAlleTvSerier();
    TvSerie getEnTvSerie(String tvSerieTittel);


    //Returne en liste med Episoder fra TvSerie X og sesong Y
    //
    ArrayList<Episode> getAlleEpisoder(int sesongNr);

    ArrayList<Episode> hentEpisoderISesong(int sesongNr);

    Episode getEnEpisode(String episodeTittel, String sesongNr);
}
