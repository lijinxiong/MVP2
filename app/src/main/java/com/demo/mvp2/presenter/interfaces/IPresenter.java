package com.demo.mvp2.presenter.interfaces;

import com.demo.mvp2.view.interfaces.IView;

/**
 * Created by jinxiong on 2017/5/20.
 */

public interface IPresenter {

    void getData();

    void attach(IView iView);

    void detach();
}
