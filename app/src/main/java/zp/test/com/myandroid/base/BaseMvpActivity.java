package zp.test.com.myandroid.base;

import android.os.Bundle;

import javax.inject.Inject;

import zp.test.com.myandroid.di.module.ActivityModule;

/**
 * Created by change on 2017/10/26.
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected abstract void initInject();

}
