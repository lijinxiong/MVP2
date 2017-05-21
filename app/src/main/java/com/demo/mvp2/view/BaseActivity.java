package com.demo.mvp2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.demo.mvp2.presenter.interfaces.IPresenter;
import com.demo.mvp2.view.interfaces.IView;

/**
 * Created by jinxiong on 2017/5/21.
 */

public abstract class BaseActivity extends AppCompatActivity implements IView {


    protected IPresenter mIPresenter;

    protected abstract IPresenter createPresenter();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIPresenter = createPresenter();
        mIPresenter.attach(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIPresenter.detach();
    }
}
