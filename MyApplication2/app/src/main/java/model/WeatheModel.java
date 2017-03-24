package model;

import java.util.List;

/**
 * Created by 1305235 on 2017/3/22.
 */

public class WeatheModel {
    private String resultcode;
    private String reason;
    List<GatherModel> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<GatherModel> getResult() {
        return result;
    }

    public void setResult(List<GatherModel> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeatheModel{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
