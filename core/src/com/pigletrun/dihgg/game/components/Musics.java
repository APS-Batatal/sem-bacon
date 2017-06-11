package com.pigletrun.dihgg.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by silmara on 04/06/2017.
 */

public class Musics {

    private Music music;

    public Musics() {
        //adiciona musica ao game
        music = Gdx.audio.newMusic(Gdx.files.internal("music/bg-music.mp3"));
        music.setLooping(true);
        music.play();
    }

    public void setVolume(float volume) {
        music.setVolume(volume);
    }
}