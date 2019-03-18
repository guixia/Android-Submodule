package com.fenlibao.submodule.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 1) //拦截器优先级别
public class UserIInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        if (RoutePath.ACTIVITY_URL_FIRST.equals(postcard.getPath())) {
//            Log.e("caoliang", "UserIInterceptor----process()---->" + "拦截处理");
//            //拦截
//            callback.onInterrupt(new Exception("未登录"));
//        } else {
//            //放行
//        }
            callback.onContinue(postcard);
    }


    @Override
    public void init(Context context) {
        Log.e("caoliang", "UserIInterceptor----init()---->" + "拦截器初始化");
    }
}
