package no.hiof.rubenlien.hellojavalin.controller;

import io.javalin.http.Context;
import no.hiof.rubenlien.hellojavalin.model.Episode;
import no.hiof.rubenlien.hellojavalin.model.TvSerie;
import no.hiof.rubenlien.hellojavalin.repository.TvSerieRepository;

import java.util.ArrayList;


public class TvSerieController {
    private TvSerieRepository tvSerieRepository;
    public TvSerieController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }


    public void getAlleTvSerier(Context context){
      ArrayList<TvSerie> alleTvSerier = tvSerieRepository.getAlleTvSerier();

     context.json(alleTvSerier);

    }

    public void getEnTvSerie(Context context){
        String serieId = context.pathParam("tvserie-id");
        TvSerie serie = tvSerieRepository.getEnTvSerie(serieId);

        context.json(serie);

    }


}
