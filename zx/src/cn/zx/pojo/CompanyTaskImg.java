package cn.zx.pojo;

public class CompanyTaskImg {
    private Integer img_id;

    private Integer task_id;

    private String img_url;

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url == null ? null : img_url.trim();
    }

	@Override
	public String toString() {
		return "CompanyTaskImg [img_id=" + img_id + ", task_id=" + task_id
				+ ", img_url=" + img_url + "]";
	}
    
}