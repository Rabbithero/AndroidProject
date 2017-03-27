package activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import demo.R;
import model.FutureModel;
import model.GatherModel;
import model.GoodModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 1305235 on 2017/3/21.
 */

public class Activity1 extends Fragment {
    private Button bt_post;
    private OkHttpClient mOkHttpClient;
    private EditText et_text;
    final Handler mHandler = new Handler();
    private Thread mUiThread;
    private RecyclerView re_view;
    private MyAdapter mAdapter;
    private GoodModel goodmodel;
    private GatherModel gathermodel=new GatherModel();
    private FutureModel futuremodel=new FutureModel();
    private TextView week1;
    private TextView data1;
    private TextView weather1;
    private TextView temperature1;
    private TextView wind1;
    private TextView dressing_advice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = View.inflate(getContext(), R.layout.fragement1, null);
        bt_post = (Button) view1.findViewById(R.id.bt_post);
        et_text = (EditText) view1.findViewById(R.id.et_text);
        re_view = (RecyclerView) view1.findViewById(R.id.re_view);
        week1 = (TextView) view1.findViewById(R.id.week1);
        data1 = (TextView) view1.findViewById(R.id.data1);
        weather1 = (TextView) view1.findViewById(R.id.weather1);
        temperature1 = (TextView) view1.findViewById(R.id.temperature1);
        dressing_advice= (TextView) view1.findViewById(R.id.dressing_advice);
        wind1 = (TextView) view1.findViewById(R.id.wind1);
        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_text.getText().toString().equals("")){
                        Toast.makeText(getActivity(),"城市不能为空",Toast.LENGTH_LONG).show();
                }else {
                    post(et_text.getText().toString());
                }

            }
        });
        if (goodmodel!=null){

            set();

        }
//        post("杭州");

        return view1;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
            if (getUserVisibleHint()){

            }else {

            }
    }

    private void post(String name) {
        mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("cityname", name)
                .build();
        Request request = new Request.Builder()
                .url("http://v.juhe.cn/weather/index?format=2&cityname=" + name + "&key=e9cd699936a1d0e6bb6d56c93fec9386")
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                goodmodel = JSON.parseObject(response.body().string(), GoodModel.class);
                if (goodmodel != null) {

                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        List<FutureModel> futureModels = new ArrayList<FutureModel>();
//                        for (int i = 0; i < goodmodel.getResult().getFuture().size(); i++) {
//                            futureModels.add(goodmodel.getResult().getFuture().get(i));
//                        }
                        Collections.reverse(goodmodel.getResult().getFuture());
                        for (int i=0 ;i<goodmodel.getResult().getFuture().size();i++){
                                if (goodmodel.getResult().getFuture().get(i).getWeek().equals(goodmodel.getResult().getToday().getWeek()))
                                goodmodel.getResult().getFuture().remove(i);
                        }
                        set();

                        Toast.makeText(getContext(), "请求成功", Toast.LENGTH_SHORT).show();

                    }
                });
            }

        });
    }


    private void set() {
        dressing_advice.setText(goodmodel.getResult().getToday().getDressing_advice());
        temperature1.setText(goodmodel.getResult().getToday().getTemperature());
        data1.setText(goodmodel.getResult().getToday().getDate_y());
        week1.setText(goodmodel.getResult().getToday().getWeek());
        weather1.setText(goodmodel.getResult().getToday().getWeather());
        wind1.setText(goodmodel.getResult().getToday().getWind());
        mAdapter = new MyAdapter(goodmodel.getResult().getFuture());
        re_view.setAdapter(mAdapter);
        re_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /*public final void runOnUiThread(Runnable action) {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(action);
        } else {
            action.run();
        }
    }*/

    class MyAdapter extends RecyclerView.Adapter<NewViewHolder> {
        private List<FutureModel> futureModel;


        public MyAdapter(List<FutureModel> futureModels) {
            futureModel = new ArrayList<>();
            this.futureModel = futureModels;
        }

        @Override
        public NewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            NewViewHolder holder = new NewViewHolder(LayoutInflater.from(getActivity())
                    .inflate(R.layout.activity1_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(NewViewHolder holder, int position) {
            holder.temperature.setText("温度:" + futureModel.get(position).getTemperature());
            holder.wind.setText("风向:" + futureModel.get(position).getWind());
            holder.data.setText("时间:" + futureModel.get(position).getDate());
            holder.week.setText("星期:" + futureModel.get(position).getWeek());
            holder.weather.setText("天气:" + futureModel.get(position).getWeather());
        }

        @Override
        public int getItemCount() {
            return futureModel.size();
        }
    }

    class NewViewHolder extends RecyclerView.ViewHolder {
        private TextView week;
        private TextView data;
        private TextView weather;
        private TextView temperature;
        private TextView wind;

        public NewViewHolder(View itemView) {
            super(itemView);
            week = (TextView) itemView.findViewById(R.id.week);
            data = (TextView) itemView.findViewById(R.id.data);
            weather = (TextView) itemView.findViewById(R.id.weather);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            wind = (TextView) itemView.findViewById(R.id.wind);
        }
    }

}
