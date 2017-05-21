package com.demo.mvp2.model.interfaces;

/**
 * Created by jinxiong on 2017/5/20.
 */

public interface IModel<T> {

    /**
     * @param loadDataListener presenter 实现这个接口，用于加载数据完成后
     *                         presenter能够知道
     * @return 因为可能需要耗时操作，不能卡死main线程，所以返回值为void
     */
    void loadData(LoadDataListener<T> loadDataListener);


    /**
     * @param
     */
    interface LoadDataListener<T> {

        /**
         * 当数据加载完成之后调用此函数
         */
        void complete(T data);

    }


}
