package com.demo.mvp2.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mvp2.R;
import com.demo.mvp2.presenter.JokePresenter;
import com.demo.mvp2.presenter.WeatherPresenter;
import com.demo.mvp2.presenter.interfaces.IPresenter;


public class MainActivity extends BaseActivity {

    private TextView mTextView;
    private Button mButton;


    @Override
    protected IPresenter createPresenter() {
//        return new WeatherPresenter();
        return new JokePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        mTextView = (TextView) this.findViewById(R.id.content_view);
        mButton = (Button) this.findViewById(R.id.download_data_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPresenter.getData();
            }
        });
    }


    /**
     * 提示用户加载开始了
     */
    @Override
    public void showDowning() {
        Toast.makeText(this, "下载中....", Toast.LENGTH_SHORT).show();
    }

    /**
     * 展示加载的数据
     *
     * @param data
     */
    @Override
    public void showData(String data) {
        mTextView.setText(data);
    }

}

