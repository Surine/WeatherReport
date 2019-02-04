package cn.surine.weatherreport.Mvp.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cn.surine.weatherreport.R;

/**
 * Created by Surine on 2018/9/2.
 */

public abstract class BaseMvpActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog mProgressDialog;
    private AlertDialog.Builder alertDialog;
    private Dialog dialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        //初始化对话框
        mProgressDialog = new ProgressDialog(this);
        //误触开关
        mProgressDialog.setCancelable(false);

        //初始化提示对话框
        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(false);

    }

    @Override
    public void showLoading(final String title, final String msg) {
        //显示加载对话框
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(!mProgressDialog.isShowing()){
                    mProgressDialog.setTitle(title);
                    mProgressDialog.setMessage(msg);
                    mProgressDialog.show();
                }
            }
        });
    }

    @Override
    public void setLoadingText(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProgressDialog.setMessage(msg);
            }
        });
    }

    @Override
    public void hideLoading() {
        //隐藏对话框
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }
        });
    }

    @Override
    public void showFailMessage(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(msg);
            }
        });
    }


    @Override
    public void showErrorMessage() {
        //显示请求错误信息
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(getResources().getString(R.string.error));
            }
        });
    }



    @Override
    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //toast
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Context getContext() {
        return context;
    }
}
