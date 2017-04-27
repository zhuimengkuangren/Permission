package com.zhuimeng.permission;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.zhuimeng.permission.constant.Constants;

/**
 * Created by 追梦 on 2017/4/27.
 **/

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 为子类提供一个权限检查方法
     * @param permissions
     * @return
     */
    public boolean hasPermission(String... permissions){
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    /**
     * 为子类提供一个权限请求方法
     * @param code
     * @param permissions
     */
    public void requestPermission(int code, String... permissions){
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.WRITE_EXTERNAL_CODE:
                doSDCardPermission();
                break;
            case Constants.CALL_PHONE_CODE:
                doCallPhone();
                break;
        }
    }

    /**
     * 默认的打电话权限处理
     */
    private void doCallPhone() {

    }

    /**
     * 默认的写SD权限处理
     */
    private void doSDCardPermission() {

    }
}
