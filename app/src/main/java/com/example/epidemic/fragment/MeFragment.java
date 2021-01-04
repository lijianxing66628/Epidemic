package com.example.epidemic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.epidemic.R;
import com.example.epidemic.activity.ApplyForPassActivity;
import com.example.epidemic.activity.CodeActivity;
import com.example.epidemic.activity.HealthReportHistoryActivity;
import com.example.epidemic.activity.LoginStudengActivity;
import com.example.epidemic.activity.UserMessageActivity;
import com.example.epidemic.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFragment extends BaseTitleFragment {


    @BindView(R.id.avator)
    ImageView avatar;

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


//    @OnClick({ R.id.generate_codeing})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.generate_codeing:
//                startActivity(new Intent(getActivity(), CodeActivity.class));
//                break;
//        }
//    }


    @Override
    protected void initViews() {
        super.initViews();
        Glide.with(getMainActivity()).load("http://bmob-cdn-28709.bmobpay.com/2020/09/27/eebf2bf6d3aa4e29aafb5f521b33423a.jpg").into(avatar);
    }

    @Override
    protected void initData() {
        super.initData();
        toolbar.setTitle("我的");
        setTitleCenter(toolbar);
    }

    @OnClick({R.id.exit,R.id.user_message,R.id.health_report,R.id.apply_pass_check})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.exit:
                PreferenceUtil.setSession(false);
                startActivityAfterFinishThis(LoginStudengActivity.class);
                 break;
            case R.id.user_message:
                startActivity(UserMessageActivity.class);
                break;
            case R.id.health_report:
                startActivity(HealthReportHistoryActivity.class);
                break;
            case R.id.apply_pass_check:
                startActivity(ApplyForPassActivity.class);
                break;
        }
    }
}
