package model;

import java.util.List;

/**
 * Created by 1305235 on 2017/3/22.
 */

public class GatherModel {
    private SkModel sk;/*当前实况天气*/
    private TodayModel today;
    private List<FutureModel> future;

    public SkModel getSk() {
        return sk;
    }

    public void setSk(SkModel sk) {
        this.sk = sk;
    }

    public TodayModel getToday() {
        return today;
    }

    public void setToday(TodayModel today) {
        this.today = today;
    }

    public List<FutureModel> getFuture() {
        return future;
    }

    public void setFuture(List<FutureModel> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "GatherModel{" +
                "sk=" + sk +
                ", today=" + today +
                ", future=" + future +
                '}';
    }
}
