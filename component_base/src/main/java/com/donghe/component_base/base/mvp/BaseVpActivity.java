package com.donghe.component_base.base.mvp;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.donghe.component_base.base.mvp.inter.IMvpCallback;
import com.donghe.component_base.base.mvp.inter.IPresenter;
import com.donghe.component_base.base.mvp.inter.IView;
import com.donghe.component_base.constants.BaseApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by donghe on 2018/10/26.
 */

public abstract class BaseVpActivity<P extends IPresenter<V>,V extends IView> extends AppCompatActivity implements IMvpCallback<V,P>,IView {

    protected P mPresenter;
    protected V mView;
    private Unbinder unbinder;
    public BaseVpActivity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        //加入activity管理
        BaseApplication.getAppContext().getActivityControl().addActivity(this);
        mActivity = this;
    }

    /**
     * 初始化presenter
     */
    public void onViewCreated() {
        mView = createView();
        if (getPresenter()==null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
        mPresenter = getPresenter();
        mPresenter.attachView(getMvpView());
    }

    @Override
    public Lifecycle getLifecycle() {
        return null;
    }

    @Override
    public P createPresenter() {
        return null;
    }

    @Override
    public V createView() {
        return null;
    }

    @Override
    public void setPresenter(P presenter) {

    }

    @Override
    public P getPresenter() {
        return null;
    }

    @Override
    public void setMvpView(V view) {

    }

    @Override
    public V getMvpView() {
        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showError(String msg, String code) {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError() {

    }


    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化标题
     */
    protected abstract void initTitle();

    /**
     * 初始化数据
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected  void loadData(){};
}
