package zp.test.com.myandroid.presenter.contract;


import java.util.List;

import zp.test.com.myandroid.base.BasePresenter;
import zp.test.com.myandroid.base.BaseView;

/**
 * Description: WelcomeContract
 * Creator: yxc
 * date: 2016/9/22 13:16
 */
public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(List<String> list);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();
    }
}
