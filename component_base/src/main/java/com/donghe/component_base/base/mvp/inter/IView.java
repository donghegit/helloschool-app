package com.donghe.component_base.base.mvp.inter;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * Created by donghe on 2018/10/26.
 */

public interface IView extends LifecycleOwner{

    Context getContext();

    /**
     * 网络请求错误，弹框提醒
     * @param msg
     * @param code
     */
    void showError(String msg, String code);

    //----------------------------下面用来显示空界面---------------------------//
    /**
     * showNormal 页面
     */
    void showNormal();

    /**
     * Show loading 页面
     */
    void showLoading();
    /**
     * Show EmptyView 页面
     */
    void showEmptyView();
    /**
     * Show error 页面
     */
    void showError();



}
