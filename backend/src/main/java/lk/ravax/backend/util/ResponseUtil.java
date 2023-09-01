package lk.ravax.backend.util;

public class ResponseUtil {
    private String code;
    private String msg;
    private Object payload;

    public ResponseUtil() {
    }

    public ResponseUtil(String code, String msg, Object payload) {
        this.code = code;
        this.msg = msg;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
