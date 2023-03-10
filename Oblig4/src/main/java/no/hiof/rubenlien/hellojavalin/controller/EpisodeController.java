package no.hiof.rubenlien.hellojavalin.controller;

import io.javalin.http.Context;
import no.hiof.rubenlien.hellojavalin.model.Episode;
import no.hiof.rubenlien.hellojavalin.repository.TvSerieRepository;

import java.util.ArrayList;

public class EpisodeController {
    private TvSerieRepository tvSerieRepository;
    public EpisodeController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void hentEpisoderISesong(Context context){
        int sesongNr = Integer.parseInt(context.pathParam("sesong-nr"));
        ArrayList<Episode> hentEpisoderISesong = tvSerieRepository.hentEpisoderISesong(sesongNr);
        context.json(hentEpisoderISesong);
    }

    public void getEnEpisode(Context context){
        String episodeNr = context.pathParam("episode-nr");
        String serieNr = context.pathParam("tvserie-id");
        Episode getEnEpisode = tvSerieRepository.getEnEpisode(serieNr, episodeNr);
        context.json(getEnEpisode);

    }



}
