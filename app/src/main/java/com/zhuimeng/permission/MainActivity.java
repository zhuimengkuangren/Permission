package com.zhuimeng.permission;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhuimeng.permission.constant.Constants;

public class MainActivity extends AppCompatActivity{

    private Button callPhone;
//    private Button readSDcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callPhone = (Button) findViewById(R.id.bt_callphone);
        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone();
            }
        });


//        initView();
    }

    //初始化UI
//    private void initView() {
//        callPhone = (Button) findViewById(R.id.bt_callphone);
//        readSDcard = (Button) findViewById(R.id.bt_readSD);

//        callPhone.setOnClickListener((View.OnClickListener) this);
//        readSDcard.setOnClickListener((View.OnClickListener) this);
//    }

//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.bt_callphone:
//                break;
//            case R.id.bt_readSD:
//                break;
//        }
//    }

    private void callPhone() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //做权限申请处理
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            doCallPhone();
        }
//        if (hasPermission(Manifest.permission.CALL_PHONE)){
//            doCallPhone();
//        } else {
//            requestPermission(Constants.CALL_PHONE_CODE, Manifest.permission.CALL_PHONE);
//        }
    }

    /**
     * 子类实现具体的打电话业务逻辑
     */
//    @Override
    public void doCallPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        this.startActivity(intent);
    }

//    private void cdCardPermission(){
////        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
////                != PackageManager.PERMISSION_GRANTED){
////            //处理权限申请逻辑
////            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
////                    WRITE_EXTERNAL_STORAGE},0);
////        } else {
////            doSDCardpermission();
////        }
//    }
//
//    private void doSDCardpermission(){
//
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case 1:
//                //打电话权限回调处理
//                if ((grantResults[1]) == PackageManager.PERMISSION_GRANTED){
//                    doCallPhone();
//                } else {
//                    //提示用户权限未被授予
//                }
//            break;
//            case 0:
//                if ((grantResults[0]) == PackageManager.PERMISSION_GRANTED){
//                    doSDCardpermission();
//                } else {
//
//                }
//            break;
//        }
//    }

}
