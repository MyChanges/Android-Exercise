package zp.test.com.myandroid.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by change on 2017/10/26.
 */

public class CommApp extends Application {
    // 共享变量
    private static Context sContext = null;
    private static Stack<Activity> mActivityStack = new Stack<Activity>();

    public static Context getContext() {
        return sContext;
    }

    static {
        // 夜间模式
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    /**
     * 添加Activity
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        if (!mActivityStack.contains(activity)) {
            mActivityStack.push(activity);
        }

    }

    /**
     * 删除activity
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
        }

    }

    /**
     * 获取所有Activity
     *
     * @return
     */
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();
        activities.addAll(mActivityStack);
        return activities;
    }

    /**
     * 获取最后的Activiy
     *
     * @return
     */
    public Activity getLastAcitivty() {
        if (!mActivityStack.isEmpty()) {
            return mActivityStack.lastElement();
        }
        return null;
    }

    /**
     * 退出App
     */
    public void exitApp() {
        Activity a = null;
        while (!mActivityStack.isEmpty()) {
            a = mActivityStack.pop();
            a.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }



}
