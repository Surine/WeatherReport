package cn.surine.weatherreport.Mvp.base;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Surine on 2018/9/2.
 * MVP：界面接口
 */

public interface BaseView {


    /**
     * 显示正在加载进度
     * @param title 标题
     * @param msg 内容
     * */
    void showLoading(String title, String msg);


    /**
     * 显示加载信息
     * @param msg 内容
     * */
    void setLoadingText(String msg);


    /**
     * 隐藏正在加载进度
     * */
    void hideLoading();


    /**
     * 数据请求失败
     * @param msg 失败原因
     * */
    void showFailMessage(String msg);


    /**
     * 数据请求异常
     * */
    void showErrorMessage();


    /**
     * 显示toast
     * @param msg toast信息
     * */
    void showToast(String msg);


    /**
     * 获取上下文
     * */
    Context getContext();


}
