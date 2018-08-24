package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class CloudEndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private MyApi myApiService = null;
    private Context context;
    private String result;

    private DataLoadCompleteCallback dataLoadCompleteCallback;

    public interface DataLoadCompleteCallback{
        void onDataLoaded(String joke);
    }

    public void setDataLoadCompleteCallback(DataLoadCompleteCallback dataLoadCompleteCallback) {
        this.dataLoadCompleteCallback = dataLoadCompleteCallback;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        if (dataLoadCompleteCallback != null) {
            dataLoadCompleteCallback.onDataLoaded(result);
            this.result = result;
        }
    }

    public String getResult() {
        return result;
    }
}
