package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by silmara on 04/06/2017.
 */

public class Musics {

    private Music music;

    public Musics(String file, float volume) {
        //adiciona musica ao game
        music = Gdx.audio.newMusic(Gdx.files.internal("music/" + file));
        music.setLooping(true);
        music.setVolume(volume);
        music.play();
    }

    public boolean playing() {
        return music.isPlaying();
    }

    public void dispose() {
        music.dispose();
    }
}