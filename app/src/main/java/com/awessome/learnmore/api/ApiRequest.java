package com.awessome.learnmore.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiRequest {
  private OkHttpClient httpClient = new OkHttpClient();

  public void call(final String url, final String method, final String data, final OnRequestComplete callback) {
    Log.d("**** call to api ****", "i m calling api");
    RequestBody body;
    if(data == null){
      body = null;
    }
    else{
      body = RequestBody.create(MediaType.parse("application/json"), data);
    }
    Request request = new Request
            .Builder()
            .method(method, body)
            .url(url)
            .build();
    httpClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        callback.onError(e.getMessage());
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        if(!response.isSuccessful()){
          callback.onError(response.body().string());
          return;
        }

        callback.onSuccess(response.body().string());
      }
    });
  }

  public interface OnRequestComplete {
    void onError(String error);
    void onSuccess(String data);
  }
}
