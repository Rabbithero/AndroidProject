package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import demo.myapplication.R;


/**
 * Created by 1305235 on 2017/3/21.
 */

public class Fragment2 extends LazyFragment{
    private boolean isPrepared=true;
    private Button mBt_map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fragement2,null);
        mBt_map = (Button) view.findViewById(R.id.bt_map);
        mBt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyMapActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    protected void lazyLoad() {
        if (isPrepared==true||!isFirst){
            isPrepared=false;
            return;
        }else {

        }
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
