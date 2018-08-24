package com.abani.exercise.android.joketeller;

import com.abani.exercise.android.joketeller.utils.JokeUtil;

public class JokeTeller {

    String joke;

    public JokeTeller() {
        joke = JokeUtil.getRandomJokes();
    }

    public String getJoke() {
        return joke;
    }
}
