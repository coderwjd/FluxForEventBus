package com.wang.leadmap.eventbusdemo.api;

import com.wang.leadmap.lmhttpcoresdk.http.ApiResponseHandle;

/**
 * Created by wang on 16/3/18.
 */
public interface UpdateViewCallback {

    void disDialog();

    void onUpdateView(ApiResponseHandle handle, Object obj);
}
