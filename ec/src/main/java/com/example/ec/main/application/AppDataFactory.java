package com.example.ec.main.application;

import com.example.ec.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan
 *         Date  2018/7/19.
 *         Function :
 *         Issue :
 */

public class AppDataFactory {

    public static ArrayList<AppBean> getPersonalList(){

        int[] personalIds = {R.mipmap.ic_sign,R.mipmap.ic_task,R.mipmap.ic_daily,R.mipmap.ic_report,R.mipmap.ic_plan,R.mipmap.ic_jia,R.mipmap.ic_rest};
        String[] texts = {"签到","任务","日志","汇报","计划","请假","调休"};
        ArrayList<AppBean> appBeanList = new ArrayList<>();

        for (int i = 0;i<personalIds.length;i++){
            AppBean appBean = new AppBean(i,personalIds[i],texts[i]);
            appBeanList.add(appBean);
        }
        return appBeanList;
    }

    public static ArrayList<AppBean> getCoordination(){

        int[] personalIds = {R.mipmap.ic_announcement,R.mipmap.ic_metting,R.mipmap.ic_publish,R.mipmap.ic_system,R.mipmap.ic_examine,R.mipmap.ic_trajectory};
        String[] texts = {"公告","会议","发布","制度","审批","轨迹",};
        ArrayList<AppBean> appBeanList = new ArrayList<>();

        for (int i = 0;i<personalIds.length;i++){
            AppBean appBean = new AppBean(i,personalIds[i],texts[i]);
            appBeanList.add(appBean);
        }
        return appBeanList;
    }
}
