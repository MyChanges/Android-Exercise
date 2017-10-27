package zp.test.com.myandroid.ui;

import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import zp.test.com.myandroid.R;
import zp.test.com.myandroid.base.BaseMvpActivity;
import zp.test.com.myandroid.component.ImageLoader;
import zp.test.com.myandroid.presenter.WelcomePresenter;
import zp.test.com.myandroid.presenter.contract.WelcomeContract;
import zp.test.com.myandroid.utils.StringUtils;

/**
 * Created by change on 2017/10/26.
 */

public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;

    @Override
    public void showError(String msg) {

    }

    @Override
    protected void initView() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(List<String> list) {
        if (list != null) {
            int page = StringUtils.getRandomNumber(0, list.size() - 1);
            ImageLoader.load(mContext, list.get(page), ivWelcomeBg);
            ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        }
    }

    @Override
    public void jumpToMain() {
        HomeActivity.start(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    @Override
    protected void initInject() {
        mPresenter = new WelcomePresenter();

    }


    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }
}
