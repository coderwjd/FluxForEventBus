package com.wang.leadmap.eventbusdemo.model.response;

import java.io.Serializable;

/**
 * Created by wang on 16/7/8.
 */
public class RepFinishTaskResponse implements Serializable{

    public String Type;//类型

    public String Num;//编号

    public int SourceTag;//来源标示

    public String Area;//片区

    public String Arrive;//到场

    public String Finish;//完成

    public String SendTime;//派发时间

    public int State;//状态（）

    public String PhoneNum;//电话

    public double LocX;//横坐标

    public double locY;//纵坐标

}
