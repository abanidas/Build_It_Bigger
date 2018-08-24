package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.abani.exercise.android.displayjoke.JokeActivity;


public class MainActivity extends AppCompatActivity implements CloudEndPointAsyncTask.DataLoadCompleteCallback{

    //private AsyncDataLoadCallback dataLoadCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        findViewById(R.id.progressDataLoad).setVisibility(View.VISIBLE);
        CloudEndPointAsyncTask endPointAsyncTask = new CloudEndPointAsyncTask();
        endPointAsyncTask.setDataLoadCompleteCallback(this);
        endPointAsyncTask.execute(new Pair<Context, String>(this, "John"));
    }

    /*@VisibleForTesting
    public void setDataLoadCallback(AsyncDataLoadCallback dataLoadCallback) {
        this.dataLoadCallback = dataLoadCallback;
    }

    @VisibleForTesting
    public void handleDataLoadResponse(String joke) {
        if (dataLoadCallback != null) {
            dataLoadCallback.onDataLoad(joke);
        }
    }*/

    @Override
    public void onDataLoaded(String joke) {
        findViewById(R.id.progressDataLoad).setVisibility(View.GONE);
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_EXTRA, joke);
        startActivity(intent);
        //handleDataLoadResponse(joke);
    }
}
