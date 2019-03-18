package com.fenlibao.submodule;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fenlibao.common.base.BaseActivity;
import com.fenlibao.common.base.BaseApplication;
import com.fenlibao.common.base.RoutePath;

import java.util.Timer;
import java.util.TimerTask;

@Route(path = RoutePath.APP_URL_MAIN)
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static Boolean isExit = false;

    @Override
    public void init() {
        BaseApplication application = BaseApplication.getInstance();
    }

    @Override
    public void initViews() {
        LinearLayout ll_find_one = findViewById(R.id.ll_find_one);
        LinearLayout ll_find_two = findViewById(R.id.ll_find_two);
        ll_find_one.setOnClickListener(this);
        ll_find_two.setOnClickListener(this);
    }
//try {
//        Class clazz = Class.forName("com.fenlibao.member.MainActivity");
//        Intent intent = new Intent(_activity, clazz);
//        startActivity(intent);
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.ll_find_one) {
            ARouter.getInstance().build(RoutePath.MEMBER_1_URL_MAIN).navigation();
        } else if (i == R.id.ll_find_two) {
            ARouter.getInstance().build(RoutePath.MALL_1_URL_MAIN).navigation();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @SuppressLint("RestrictedApi")
    public boolean dispatchKeyEvent(KeyEvent event) {
        try {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                    && event.getRepeatCount() == 0
                    && event.getAction() == KeyEvent.ACTION_DOWN) {
                exitBy2Click();
                return false;
            } else {
                return super.dispatchKeyEvent(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }


    private void exitBy2Click() {
        Timer tExit;
        if (!isExit) {
            isExit = true; // 准备退出
            Toast.makeText(_activity, "再按一次退出应用", Toast.LENGTH_LONG).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            _activity.finish();
        }
    }

}
