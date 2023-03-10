package no.hiof.rubenlien.hellojavalin;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.vue.VueComponent;
import io.javalin.http.Handler;
import no.hiof.rubenlien.hellojavalin.controller.EpisodeController;
import no.hiof.rubenlien.hellojavalin.controller.TvSerieController;
import no.hiof.rubenlien.hellojavalin.repository.TvSerieDataRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(7070);


        TvSerieDataRepository tvSerieDataRepository = new TvSerieDataRepository();
        TvSerieController tvSerieController = new TvSerieController(tvSerieDataRepository);
        EpisodeController episodeController = new EpisodeController(tvSerieDataRepository);

        app.get("/tvserie", new VueComponent("tvserie-overview"));
        app.get("/api/tvserie", new Handler() {

            @Override
            public void handle(@NotNull Context context) throws Exception {
                  tvSerieController.getAlleTvSerier(context);
            }
        });

        app.get("/tvserie/{tvserie-id}", new VueComponent("tvserie-detail"));
        app.get("/api/tvserie/{tvserie-id}", new Handler() {

            @Override
            public void handle(@NotNull Context context) throws Exception {
                tvSerieController.getEnTvSerie(context);
            }
        });

        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}", new VueComponent("tvserie-detail"));
        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}", new Handler() {

            @Override
            public void handle(@NotNull Context context) throws Exception {
                episodeController.hentEpisoderISesong(context);
            }
        });

        app.get("/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new VueComponent("episode-detail"));
        app.get("/api/tvserie/{tvserie-id}/sesong/{sesong-nr}/episode/{episode-nr}", new Handler() {

            @Override
            public void handle(@NotNull Context context) throws Exception {
                episodeController.getEnEpisode(context);
            }
        });


    }
}
