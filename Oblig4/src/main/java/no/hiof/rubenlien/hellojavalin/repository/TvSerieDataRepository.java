package no.hiof.rubenlien.hellojavalin.repository;

import no.hiof.rubenlien.hellojavalin.model.Episode;
import no.hiof.rubenlien.hellojavalin.model.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerieDataRepository implements TvSerieRepository{

    private ArrayList<TvSerie> tvSeries = new ArrayList<>();


    public TvSerieDataRepository(){
        TvSerie blacklist = new TvSerie("Blacklist",
                "Raymond Reddington, who has eluded capture for decades, turns himself in to the FBI",
                LocalDate.of(2016, 7,15), "https://i.pinimg.com/564x/fe/3b/e7/fe3be74cf94ebb76b6941df7b03fdc22.jpg");


        Episode episode1 = new Episode("Chapter One: Pilot", 1, 1, 30, LocalDate.of(2011, 4, 11), "FillerText", "https://tv-fanatic-res.cloudinary.com/iu/s--A2WMCaEV--/t_full/cs_srgb,f_auto,fl_strip_profile.lossy,q_auto:420/v1380048659/megan-boone-on-the-blacklist.jpg");
        Episode episode2 = new Episode("Chapter Two: The Freelancer", 2, 1, 20, LocalDate.of(2011, 4, 11), "FillerText", "https://i.pinimg.com/originals/6b/a5/cb/6ba5cb529ca46660e1f432f07723964b.jpg");
        Episode episode3 = new Episode("Chapter Three: Wujing", 3, 1, 10, LocalDate.of(2011, 4, 11), "FillerText", "https://i.pinimg.com/564x/b8/a3/5a/b8a35ae644d55eb9516e09c4e076f2ea.jpg");
        Episode episode4 = new Episode("Chapter Four: The Stewmaker", 4, 1, 40, LocalDate.of(2011, 4, 11), "FillerText", "https://i.pinimg.com/564x/70/ea/b4/70eab4fb27e6b2dc48ed42510900859d.jpg");



        blacklist.leggTilEpisode(episode1);
        blacklist.leggTilEpisode(episode2);
        blacklist.leggTilEpisode(episode3);
        blacklist.leggTilEpisode(episode4);

        tvSeries.add(blacklist);




    }


    @Override
    public ArrayList<TvSerie> getAlleTvSerier() {
        return tvSeries;
    }


    //Legger til en serie inn hvis den finner en string i .getTittel
    @Override
    public TvSerie getEnTvSerie(String tvSerieTittel) {
        for (TvSerie serie : tvSeries) {
            if (serie.getTittel().equals(tvSerieTittel))
                return serie;
        }

        return null;
    }


    @Override
    public ArrayList<Episode> getAlleEpisoder(int sesongNr) {
        for (TvSerie serie : tvSeries){
                for (Episode episode : serie.getEpisoder()){
                    if(episode.getSesongNr() == sesongNr){
                        return getAlleEpisoder(sesongNr);
                    }
                }

        }
        return new ArrayList<>();
    }
    @Override
    public ArrayList<Episode> hentEpisoderISesong(int sesong) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();
        for(TvSerie serie : tvSeries) {

            for (Episode episode : serie.getEpisoder()) {
                if (episode.getSesongNr() == sesong)
                    episoderISesong.add(episode);
            }
        }
        return episoderISesong;
    }

    @Override
    public Episode getEnEpisode(String episodeTittel, String episodeNr) {
        for (TvSerie serie : tvSeries){
            if(serie.getTittel().equals(episodeTittel)){
                for (Episode episode : serie.getEpisoder()){
                    if(episode.getEpisodeNr() == Integer.parseInt(episodeNr)){
                        return episode;
                    }
                }
            }
        }
        return null;
    }
}
