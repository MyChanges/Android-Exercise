package zp.test.com.myandroid.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import zp.test.com.myandroid.di.scope.ActivityScope;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
