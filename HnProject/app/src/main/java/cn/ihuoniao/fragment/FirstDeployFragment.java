package cn.ihuoniao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cn.ihuoniao.R;
import cn.ihuoniao.util.LogProxy;

/**
 * Created by sdk-app-shy on 2017/3/16.
 */

public class FirstDeployFragment extends Fragment {

    private ImageView ivPic = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_deploy, container, false);

        ivPic = (ImageView) rootView.findViewById(R.id.iv_first_deploy_pic);
        LogProxy.i("bbbb");

        return rootView;
    }

    public void setPicUrl(String url) {
        LogProxy.i("aaaaa");
    }
}
