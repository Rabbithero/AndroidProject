package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.myapplication.R;


/**
 * Created by 1305235 on 2017/3/21.
 */

public class Activity2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.fragement2,null);
        return view;
    }
    //        @Override
//    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
//        View view=View.inflate(getContext(), R.layout.support_simple_spinner_dropdown_item,null);
//        return super.getLayoutInflater(savedInstanceState);
//    }
//    private Button bt_lll;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragement2);
//        bt_lll= (Button) findViewById(R.id.bt_lll);
//        bt_lll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getBaseContext(),"sssss", LENGTH_LONG).show();
//            }
//        });
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
