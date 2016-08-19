package com.wang.leadmap.eventbusdemo.api;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;
import com.wang.leadmap.lmhttpcoresdk.http.ApiResponse;
import com.wang.leadmap.lmhttpcoresdk.http.AppResponseHandle;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ying on 2016/7/19.
 */
public class GetRTRMyTaskControl extends AppResponseHandle<ApiResponse<List<RepFinishTaskResponse>>> {
    private Context context;
    private UpdateViewCallback callback;

    public GetRTRMyTaskControl(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    public Type getClassType() {
        return new TypeToken<ApiResponse<List<RepFinishTaskResponse>>>(){}.getType();
    }

    @Override
    public void onFinish(boolean b, boolean b1, ApiResponse<List<RepFinishTaskResponse>> response, String s) {
        if (callback!=null){
            callback.disDialog();
        }

        if (!b1)
            showText(s);
        else {
            if (response!=null && response.getResponseState().getResponseCode()!=200){
                showText(response.getResponseState().getResponseMsg());
            }
            if (callback!=null)
                callback.onUpdateView(this,response==null ? null:response.getObj());
        }


    }

    public void setCallback(UpdateViewCallback callback) {
        this.callback = callback;

    }
}
