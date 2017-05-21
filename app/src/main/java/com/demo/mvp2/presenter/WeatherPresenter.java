package com.demo.mvp2.presenter;

import android.app.Activity;

import com.demo.mvp2.model.bean.WeatherData;
import com.demo.mvp2.model.WeatherModel;
import com.demo.mvp2.model.interfaces.IModel;
import com.demo.mvp2.model.interfaces.IModel.LoadDataListener;
import com.demo.mvp2.view.interfaces.IView;

/**
 * Created by jinxiong on 2017/5/20.
 */
public class WeatherPresenter extends BasePresenter<WeatherData> {


    @Override
    protected IModel createModel() {
        return new WeatherModel();
    }


    @Override
    public void getData() {


        IView iView = mIViewWeakReference.get();
        if (null != iView) {
            //提示用户下载开始了
            iView.showDowning();
        }

        //开始下载
        mIModel.loadData(new LoadDataListener<WeatherData>() {


            /**
             * model层下载完成回调此函数，将数据传过来,这里注意的是这个方法是在model层被调用了，
             * 而我们是在子线程中下载数据，这个方法也是在子线程中被回调，所以更新ui需要注意
             * @param data
             */

            @Override
            public void complete(final WeatherData data) {
                IView iView = mIViewWeakReference.get();

                if (null != iView) {

                    ((Activity) iView).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            IView iView = mIViewWeakReference.get();
                            if (null != iView) {

                                iView.showData(data.getStatus());
                            }
                        }
                    });
                }
            }


        });


    }


}
