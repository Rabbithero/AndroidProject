package demo.myapplication;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;


import com.mob.MobSDK;

import java.util.HashSet;
import java.util.Set;

import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by 1305235 on 2017/4/5.
 */

public class MyApplication extends Application{
//    1f09782f066ca
//            bb53cd6c343231ccec601e78014f1bc4
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);//正式版本设置fase
        JPushInterface.init(this);
        Set<String> set = new HashSet<>();
        set.add("小黄人");
        JPushInterface.setTags(this,set,null);
//        MobSDK.init(getApplicationContext(),);
    }
}
