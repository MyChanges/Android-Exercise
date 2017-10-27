package zp.test.com.myandroid.ui;

import android.content.Context;
import android.content.Intent;

import zp.test.com.myandroid.R;
import zp.test.com.myandroid.base.BaseActivity;

/**
 * Created by change on 2017/10/26.
 */

public class HomeActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }
}
