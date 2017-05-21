package com.demo.mvp2.model;

import android.util.Log;

import com.demo.mvp2.model.bean.WeatherData;
import com.demo.mvp2.model.interfaces.IModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jinxiong on 2017/5/20.
 */

public class WeatherModel<T> implements IModel<T> {

    private static final String TAG = "WeatherModel";
    private final String URL = "http://tj.nineton.cn/Heart/index/future24h/?city=CHSH000000&language=zh-chs&key=36bdd59658111bc23ff2bf9aaf6e345c";
    /**
     * @param loadDataListener presenter 实现这个接口，用于加载数据完成后
     *                         presenter能够知道
     */
    @Override
    public void loadData(final IModel.LoadDataListener loadDataListener) {


        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    URL url = new URL(URL);

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


                    WeatherData weatherData = gson.fromJson(s, WeatherData.class);

                    inputStream.close();

                    loadDataListener.complete(weatherData);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }
}
