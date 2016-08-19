package com.wang.leadmap.eventbusdemo.actions;

import android.content.Context;

import com.wang.leadmap.eventbusdemo.api.ApiActionImpl;
import com.wang.leadmap.eventbusdemo.api.GetRTRMyTaskControl;
import com.wang.leadmap.eventbusdemo.api.UpdateViewCallback;
import com.wang.leadmap.eventbusdemo.dispatcher.Dispatcher;
import com.wang.leadmap.eventbusdemo.model.request.RepTaskRequest;
import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;
import com.wang.leadmap.eventbusdemo.model.response.RepInfo;
import com.wang.leadmap.lmhttpcoresdk.http.ApiResponseHandle;

import java.util.List;

/**
 * Created by wang on 16/7/26.
 */
public class ActionsCreator implements UpdateViewCallback{
    private static ActionsCreator instance;
    private final Dispatcher dispatcher;
    private Context context;

    private ActionsCreator(Context context,Dispatcher dispatcher){
        this.context = context;
        this.dispatcher = dispatcher;
    }

    public static synchronized ActionsCreator getInstance(Context context,Dispatcher dispatcher){
        if (instance == null)
            instance = new ActionsCreator(context,dispatcher);

        return instance;
    }

    public void sendMessage(String message){
        dispatcher.dispatch(new MessageAction(MessageAction.ACTION_NEW_MESSAGE,message));
    }

    public void sendOldMessage(String old){
        this.dispatcher.dispatch(new MessageAction(MessageAction.ACTION_OLD_MESSAGE,old));
    }

    public void getRepInfo(){
        RepTaskRequest repTaskRequest=new RepTaskRequest();
        repTaskRequest.HistoryMonth="2016-08";
        repTaskRequest.TaskState=4;

        ApiActionImpl apiAction = ApiActionImpl.getInstance(context);
        apiAction.setUrl("http://183.129.204.238:9027/classes/handler/MobileServices.ashx?method=");
        GetRTRMyTaskControl control = new GetRTRMyTaskControl(context);
        control.setCallback(this);
        apiAction.GetRTRFinishTask(repTaskRequest,control);

    }

    @Override
    public void disDialog() {

    }

    @Override
    public void onUpdateView(ApiResponseHandle handle, Object obj) {
        List<RepFinishTaskResponse> responses = (List<RepFinishTaskResponse>) obj ;
        dispatcher.dispatch(new RepInfoAction(RepInfoAction.ACTION_GET_REP_INFO,responses));
    }
}
