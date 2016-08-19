package com.wang.leadmap.eventbusdemo.api;

import android.content.Context;

import com.wang.leadmap.eventbusdemo.model.request.RepTaskRequest;
import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;
import com.wang.leadmap.lmhttpcoresdk.http.ApiResponse;
import com.wang.leadmap.lmhttpcoresdk.http.ApiWrapper;
import com.wang.leadmap.lmhttpcoresdk.http.AppResponseHandle;
import com.wang.leadmap.lmhttpcoresdk.http.GsonRequest;
import com.wang.leadmap.lmhttpcoresdk.http.LmVolley;


import java.util.List;

/**
 * Created by wang on 16/7/15.
 */
public class ApiActionImpl implements ApiAction {

    private static ApiActionImpl instance;
    private Context context;

    private String url;

    private ApiActionImpl(Context context)
    {
        this.context = context;
    }

    public static ApiActionImpl getInstance(Context context) {
        if (instance == null)
            instance = new ApiActionImpl(context);
        return instance;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public void GetRTRFinishTask(RepTaskRequest request, AppResponseHandle<ApiResponse<List<RepFinishTaskResponse>>> handle) {
        LmVolley.getInstance(context).setURL(url);
        GsonRequest gsonRequest= LmVolley.getInstance(context).initRequest("LoadMyTaskListsOld&moudle=Rep",request,new ApiWrapper(handle));
        gsonRequest.setUserId("172");
        LmVolley.getInstance(context).addJsonRequest(gsonRequest);
    }

}
