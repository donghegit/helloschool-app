package com.donghe.component_base.constants;

import android.app.Application;

/**
 * Created by donghe on 2018/10/26.
 */

public class BaseApplication extends Application{

    private static BaseApplication mBaseApplication;
    //Activity管理
    private ActivityControl mActivityControl;




    @Override
    public void onCreate() {
        super.onCreate();
        mActivityControl = new ActivityControl();
        //arouter路由初始化

    }

    public ActivityControl getActivityControl(){
        return mActivityControl;
    }

    public static BaseApplication getAppContext(){
        return mBaseApplication;
    }


}
