package com.donghe.component_base.base.mvp.inter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

/**
 * Created by donghe on 2018/10/26.
 */

public interface IPresenter<V extends IView> extends LifecycleObserver {

    /**
     * 创建View时调用  在initView 之后
     * @param view
     */
    void attachView(V view);


    /**
     * view销毁时调用释放资源
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void detachView();

    Context getContext();


}
