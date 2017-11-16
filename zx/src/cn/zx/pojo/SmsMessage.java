package cn.zx.pojo;

public class SmsMessage {
    private Integer msg_id;

    private String uid;

    private String key;

    private String smsmob;

    private String smtext;

    public Integer getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Integer msg_id) {
        this.msg_id = msg_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getSmsmob() {
        return smsmob;
    }

    public void setSmsmob(String smsmob) {
        this.smsmob = smsmob == null ? null : smsmob.trim();
    }

    public String getSmtext() {
        return smtext;
    }

    public void setSmtext(String smtext) {
        this.smtext = smtext == null ? null : smtext.trim();
    }
}