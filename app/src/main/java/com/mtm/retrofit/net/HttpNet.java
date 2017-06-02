package com.mtm.retrofit.net;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * ***************************************************************************
 * Author : MTM Created by WangPeng    ***    ***     **********   ***    ***
 * Data : 2017/06/02 13:00            ****   ****    **********   ****   ****
 * Project : Retrofit                *** *  * ***       ***      *** *  * ***
 * MinSdkVersion : 16               ***  * *  ***      ***      ***  * *  ***
 * Version : V1.0                  ***   **   ***     ***      ***   **   ***
 * Description : 网络请求类
 * ***************************************************************************
 */

public class HttpNet {

    /**   单利模式   **/
    private volatile static HttpNet singleton;

    private HttpNet() {
    }
    public static HttpNet getInstence() {
        if (singleton == null) {
            synchronized (HttpNet.class) {
                if (singleton == null) {
                    singleton = new HttpNet();
                }
            }
        }
        return singleton;
    }

    /**   请求参数   **/

    //请求地址
    String root = "http://123.124.131.199:80/nnhis/mobile/";

    //需要拿到Json的字符串自己转换的
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(root)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();
    public HttpServer server = retrofit.create(HttpServer.class);
}
