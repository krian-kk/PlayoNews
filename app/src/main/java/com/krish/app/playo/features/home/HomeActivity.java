package com.krish.app.playo.features.home;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.krish.app.playo.R;
import com.krish.app.playo.features.application.base.BaseActivity;
import com.krish.app.playo.features.home.home.HomeFragment;
import com.krish.app.playo.features.home.interfaces.IHomeActivityCallback;
import com.krish.app.playo.features.result.ResultFragment;
import com.krish.app.playo.features.web.WebFragment;

import static com.krish.app.playo.utils.Utilities.hideKeyboard;

public class HomeActivity extends BaseActivity implements IHomeActivityCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            swapFragment(HomeFragment.newInstance(), false, false);
        }
    }

    @Override
    protected int getContainerViewId() {
        return R.id.activity_home_fragment_container;
    }

    @Override
    public void moveToResults(String query) {
        hideKeyboard(this);
        swapFragment(ResultFragment.newInstance(query), true, true);
    }

    @Override
    public void moveToWebPage(String url, String title) {
        swapFragment(WebFragment.newInstance(url,title), true, true);
    }
}