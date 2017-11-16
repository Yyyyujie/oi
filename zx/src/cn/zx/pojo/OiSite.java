package cn.zx.pojo;

public class OiSite {
    private Integer s_id;

    private String s_URL;

    private String s_title;

    private String s_name;

    private String s_depict;

    private String s_keywords;

    private String s_edition;

    private String s_record;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getS_URL() {
        return s_URL;
    }

    public void setS_URL(String s_URL) {
        this.s_URL = s_URL == null ? null : s_URL.trim();
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title == null ? null : s_title.trim();
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name == null ? null : s_name.trim();
    }

    public String getS_depict() {
        return s_depict;
    }

    public void setS_depict(String s_depict) {
        this.s_depict = s_depict == null ? null : s_depict.trim();
    }

    public String getS_keywords() {
        return s_keywords;
    }

    public void setS_keywords(String s_keywords) {
        this.s_keywords = s_keywords == null ? null : s_keywords.trim();
    }

    public String getS_edition() {
        return s_edition;
    }

    public void setS_edition(String s_edition) {
        this.s_edition = s_edition == null ? null : s_edition.trim();
    }

    public String getS_record() {
        return s_record;
    }

    public void setS_record(String s_record) {
        this.s_record = s_record == null ? null : s_record.trim();
    }
}