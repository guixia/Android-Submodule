package com.fenlibao.submodule.base;

import android.content.pm.ApplicationInfo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fenlibao.common.base.BaseApplication;

/**
 * ARouter在MyApplication中初始化
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if (isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public boolean isDebug() {
        return getApplicationInfo() != null && (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
