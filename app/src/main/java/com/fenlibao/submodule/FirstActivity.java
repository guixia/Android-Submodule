package com.fenlibao.submodule;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.fenlibao.common.base.BaseActivity;
import com.fenlibao.common.base.RoutePath;
import com.fenlibao.submodule.model.User;

@Route(path = RoutePath.APP_URL_FIRST)
public class FirstActivity extends BaseActivity {
    /**
     * 03 18 11 40
     */
    @Autowired
    String userId;

    @Autowired
    User user;

    @Override
    public void init() {
        Log.e("caoliang", "FirstActivity----init()--userId-->" + userId);
        Log.e("caoliang", "FirstActivity----init()--user-->" + user);
    }

    @Override
    public void initViews() {
        Button bt_button1 = findViewById(R.id.bt_button1);
        bt_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RoutePath.APP_URL_MAIN).navigation();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_first;
    }
}
