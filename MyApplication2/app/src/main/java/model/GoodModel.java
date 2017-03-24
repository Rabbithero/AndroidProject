package model;

/**
 * Created by 1305235 on 2017/3/23.
 */

public class GoodModel {
    private String resultcode;
    private String reason;
    private GatherModel result;
    private Integer error_code;

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

    public GatherModel getResult() {
        return result;
    }

    public void setResult(GatherModel result) {
        this.result = result;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "GoodModel{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
