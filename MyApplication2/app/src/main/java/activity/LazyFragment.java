package activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by 1305235 on 2017/3/27.
 */

public abstract class LazyFragment extends Fragment{
    protected boolean isFirst =true;
    Context mContext;
    boolean isOk= false;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onVisible();
        ButterKnife.bind(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            if (isFirst) {
                onVisible();
            }
        }else {
            onInvisble();
        }
    }

    protected void onInvisble() {
    }

    protected void onVisible() {
        if (isOk) {
            lazyLoad();
        }
        else
            isOk = true;
    }

    protected abstract void lazyLoad();
}
