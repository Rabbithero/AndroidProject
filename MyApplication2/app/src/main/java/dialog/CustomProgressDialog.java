package dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import demo.myapplication.R;

/**
 * Created by 1305235 on 2017/3/27.
 */

public class CustomProgressDialog extends ProgressDialog {
    private AnimationDrawable mAnimation;
    private Context mContext;
    private ImageView mImageView;
    private String mLoadingTip;
    private TextView mLoadingTv;
    private int count = 0;
    private String oldLoadingTip;
    private RelativeLayout relativeLayout;
    private int mResid;
    public CustomProgressDialog(Context context, int id,int theme) {
        super(context, theme);
        this.mContext = context;
//        this.mLoadingTip = content;
        this.mResid = id;
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mImageView.setBackgroundResource(mResid);
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = (AnimationDrawable) mImageView.getBackground();
        // 为了防止在onCreate方法中只显示第一帧的解决方案之一
        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();

            }
        });
        mLoadingTv.setText("加载中");
    }
    public void setContent(String str) {
        mLoadingTv.setText(str);
    }
    private void initView() {
        setContentView(R.layout.progress_dialog);
        mLoadingTv = (TextView) findViewById(R.id.loadingTv);
        mImageView = (ImageView) findViewById(R.id.loadingIv);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_process);
        relativeLayout.setBackgroundResource(R.color.transparent);
    }
}
