package com.example.epidemic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.epidemic.R;
import com.example.epidemic.activity.CodeActivity;

import butterknife.OnClick;

public class MeFragment extends BaseTitleFragment {


    /**
     * 构造方法
     *
     * 固定写法
     *
     * @return
     */
    public static MeFragment newInstance() {
        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /***
     * 获取View
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me,container,false);
    }


    @OnClick({ R.id.generate_codeing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.generate_codeing:
                startActivity(new Intent(getActivity(), CodeActivity.class));
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("我的");
        setTitleCenter(toolbar);
    }

}