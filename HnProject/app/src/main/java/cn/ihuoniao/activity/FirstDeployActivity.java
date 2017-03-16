package cn.ihuoniao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.ihuoniao.R;
import cn.ihuoniao.adapter.FirstDeployPageAdapter;
import cn.ihuoniao.base.BaseFragmentActivity;
import cn.ihuoniao.fragment.FirstDeployFragment;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class FirstDeployActivity extends BaseFragmentActivity {

    private List<Fragment> listFragment = new ArrayList<>();
    private ViewPager vp = null;
    private FragmentPagerAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_deploy);
        init();
    }

    @Override
    protected void initData() {
        super.initData();

        for (int i = 0; i < 5; i++) {
            Fragment fragment = new FirstDeployFragment();
            listFragment.add(fragment);
        }
        adapter = new FirstDeployPageAdapter(getSupportFragmentManager(), listFragment);
        vp.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        super.initView();

        vp = getView(R.id.vp_first_page);
    }
}
