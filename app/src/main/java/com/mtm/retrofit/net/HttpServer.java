package com.mtm.retrofit.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * ***************************************************************************
 * Author : MTM Created by WangPeng    ***    ***     **********   ***    ***
 * Data : 2017/06/02 13:12            ****   ****    **********   ****   ****
 * Project : Retrofit                *** *  * ***       ***      *** *  * ***
 * MinSdkVersion : 16               ***  * *  ***      ***      ***  * *  ***
 * Version : V1.0                  ***   **   ***     ***      ***   **   ***
 * Description : 请求接口
 * ***************************************************************************
 */

public interface HttpServer {

    @GET("mobile!getThreeDiscipline.do")
    Call<String> getTextData(
            @Query("userId") String userId,
            @Query("year") String year
    );
}
