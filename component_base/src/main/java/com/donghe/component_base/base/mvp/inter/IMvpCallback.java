package com.donghe.component_base.base.mvp.inter;

/**
 * Created by donghe on 2018/10/26.
 */

public interface IMvpCallback <V extends IView,P extends IPresenter<V>>{

    //创建Presenter  调用在init中
    P createPresenter();

    //创建View
    V createView();

    void setPresenter(P presenter);

    P getPresenter();

    void setMvpView(V view);

    V getMvpView();
}
