package com.wang.leadmap.eventbusdemo.stores;

import com.wang.leadmap.eventbusdemo.actions.Action;
import com.wang.leadmap.eventbusdemo.actions.RepInfoAction;
import com.wang.leadmap.eventbusdemo.model.response.RepFinishTaskResponse;
import com.wang.leadmap.eventbusdemo.model.response.RepInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 16/8/19.
 */
public class GetRepInfoStore extends Store {

    private List<RepFinishTaskResponse> responses = new ArrayList<>();

    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent(RepInfoAction.ACTION_GET_REP_INFO);
    }

    @Override
    public void onAction(Action action) {
        switch (action.getType()){
            case RepInfoAction.ACTION_GET_REP_INFO:
                if (action.getData() == null)
                    return;
                responses.clear();
                responses.addAll((List<RepFinishTaskResponse>) action.getData());
                break;
        }
        emitStoreChange();
    }

    public List<RepFinishTaskResponse> getResponses(){
        return responses;
    }

}
