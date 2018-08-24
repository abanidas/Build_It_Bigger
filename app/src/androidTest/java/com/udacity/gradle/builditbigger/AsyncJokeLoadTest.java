package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Handler;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncJokeLoadTest {

    @Test
    public void testAsyncTaskDataLoad(){

        final CloudEndPointAsyncTask asyncTask = new CloudEndPointAsyncTask();
        asyncTask.execute(new Pair<>(getContext(), "John"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        assertNotNull(asyncTask.getResult());
                    }
                }, 2000);
            }
        });


    }
}
