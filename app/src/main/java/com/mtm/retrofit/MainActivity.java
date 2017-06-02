package com.mtm.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mtm.retrofit.net.HttpNet;
import com.mtm.retrofit.net.HttpServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * ***************************************************************************
 * Author : MTM Created by WangPeng    ***    ***     **********   ***    ***
 * Data : 2017/06/02 13:20            ****   ****    **********   ****   ****
 * Project : Retrofit                *** *  * ***       ***      *** *  * ***
 * MinSdkVersion : 16               ***  * *  ***      ***      ***  * *  ***
 * Version : V1.0                  ***   **   ***     ***      ***   **   ***
 * Description : 测试请求数据
 * ***************************************************************************
 */
public class MainActivity extends AppCompatActivity {

    private Button btn_test;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        btn_test = (Button) findViewById(R.id.btn_test);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    private void setListener() {
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDownload();
            }
        });
    }


    private void initDownload() {

        Call<String> textData = HttpNet.getInstence().server.getTextData("2c909ebf597ce1d40159b508754f5fb3", "2016");

        textData.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String body = response.body();
                tv_content.setText(body);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
}
