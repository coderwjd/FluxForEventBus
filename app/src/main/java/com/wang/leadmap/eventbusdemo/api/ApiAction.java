package com.wang.leadmap.eventbusdemo.api;


import com.wang.leadmap.eventbusdemo.model.request.RepTaskRequest;
import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;
import com.wang.leadmap.lmhttpcoresdk.http.ApiResponse;
import com.wang.leadmap.lmhttpcoresdk.http.AppResponseHandle;

import java.util.List;

/**
 * Created by wang on 16/7/15.
 */
public interface ApiAction {


    void GetRTRFinishTask(RepTaskRequest request, AppResponseHandle<ApiResponse<List<RepFinishTaskResponse>>> handle);


}
