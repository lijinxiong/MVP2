package com.demo.mvp2.presenter;

import com.demo.mvp2.model.interfaces.IModel;
import com.demo.mvp2.presenter.interfaces.IPresenter;
import com.demo.mvp2.view.interfaces.IView;

import java.lang.ref.WeakReference;

/**
 * Created by jinxiong on 2017/5/21.
 */

public abstract class BasePresenter<T> implements IPresenter {


    protected WeakReference<IView> mIViewWeakReference;
    protected IModel<T> mIModel;

    public BasePresenter() {
        mIModel = createModel();
    }

    protected abstract IModel createModel();



    @Override
    public void attach(IView iView) {
        mIViewWeakReference = new WeakReference<IView>(iView);
    }

    @Override
    public void detach() {
        if (null != mIViewWeakReference) {
            mIViewWeakReference.clear();
        }
    }
}
