package demo.myapplication;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.mapapi.SDKInitializer;

import java.util.HashSet;
import java.util.Set;

import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by 1305235 on 2017/4/5.
 */

public class MyLocating extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);//正式版本设置fase
        JPushInterface.init(this);
        Set<String> set = new HashSet<>();
        set.add("小黄人");
        JPushInterface.setTags(this,set,null);
    }
}
