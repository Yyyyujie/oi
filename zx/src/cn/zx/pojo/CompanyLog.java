package cn.zx.pojo;

public class CompanyLog {
    private Integer l_id;

    private Integer c_id;

    private String content;

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "CompanyLog [l_id=" + l_id + ", c_id=" + c_id + ", content="
				+ content + "]";
	}
    
}