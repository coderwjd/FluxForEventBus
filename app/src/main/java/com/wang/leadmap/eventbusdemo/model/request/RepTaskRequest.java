package com.wang.leadmap.eventbusdemo.model.request;

import java.io.Serializable;

/**
 * Created by Ying on 2016/7/18.
 */
public class RepTaskRequest implements Serializable {
    /**
     * 如果该对象不赋值,则服务端返回未派发和已派发未处理的数据
     */
    public String HistoryMonth;//历史月份

    public int TaskState;//状态（3:获取未派发和已派发未处理, 4:已完成 ）

}
