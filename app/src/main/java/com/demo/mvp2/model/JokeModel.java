package com.demo.mvp2.model;

import android.util.Log;

import com.demo.mvp2.model.bean.JokeData;
import com.demo.mvp2.model.interfaces.IModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jinxiong on 2017/5/21.
 */

public class JokeModel implements IModel<JokeData> {


    private static final String TAG = "JokeModel";
    private final String URL = "http://lf.snssdk.com/neihan/service/tabs/?" +
            "essence=1&iid=3216590132&device_id=32613520945&ac=wifi&channel=360&" +
            "aid=7&app_name=joke_essay&version_code=612&version_name=6.1.2&" +
            "device_platform=android&ssmix=a&device_type=sansung&device_brand=xiaomi&os_api=28&" +
            "os_version=6.10.1&uuid=326135942187625&openudid=3dg6s95rhg2a3dg5&" +
            "manifest_version_code=612&resolution=1450*2800&dpi=620&update_version_code=6120";

    @Override
    public void loadData(final LoadDataListener<JokeData> loadDataListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    java.net.URL url = new URL(URL);

                    URLConnection urlConnection = url.openConnection();
                    InputStream inputStream = urlConnection.getInputStream();


                    StringBuilder builder = new StringBuilder();


                    byte[] bytes = new byte[1024];
                    int volumn = -1;
                    while ((volumn = inputStream.read(bytes)) != -1) {

                        builder.append(new String(bytes, 0, volumn));
                    }


                    String s = builder.toString();

                    Log.d(TAG, "run: " + s);

                    Gson gson = new Gson();


                    JokeData jokeData = gson.fromJson(s, JokeData.class);

                    inputStream.close();

                    loadDataListener.complete(jokeData);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
}
