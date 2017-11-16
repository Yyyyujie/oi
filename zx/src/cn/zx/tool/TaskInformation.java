package cn.zx.tool;

import java.util.List;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskImg;
import cn.zx.pojo.CompanyTaskProgress;
import cn.zx.pojo.CompanyTaskRemark;

public class TaskInformation {
	private CompanyTask companyTask;//任务信息
	private CompanyStaffer receiver;//接收人
	private List<CompanyTaskImg> taskimgs;//任务图片
	private List<CompanyTaskProgress> progress;//任务进度日志
	private CompanyTaskRemark remark;//任务评价
	private int surplusdays;//剩余天数
	
	
	
	@Override
	public String toString() {
		return "TaskInformation [companyTask=" + companyTask + ", receiver=" + receiver + ", taskimgs=" + taskimgs
				+ ", progress=" + progress + ", remark=" + remark + ", surplusdays=" + surplusdays + "]";
	}
	public CompanyTask getCompanyTask() {
		return companyTask;
	}
	public void setCompanyTask(CompanyTask companyTask) {
		this.companyTask = companyTask;
	}
	
	public CompanyStaffer getReceiver() {
		return receiver;
	}
	public void setReceiver(CompanyStaffer receiver) {
		this.receiver = receiver;
	}
	public List<CompanyTaskImg> getTaskimgs() {
		return taskimgs;
	}
	public void setTaskimgs(List<CompanyTaskImg> taskimgs) {
		this.taskimgs = taskimgs;
	}
	public List<CompanyTaskProgress> getProgress() {
		return progress;
	}
	public void setProgress(List<CompanyTaskProgress> progress) {
		this.progress = progress;
	}
	public CompanyTaskRemark getRemark() {
		return remark;
	}
	public void setRemark(CompanyTaskRemark remark) {
		this.remark = remark;
	}
	public int getSurplusdays() {
		return surplusdays;
	}
	public void setSurplusdays(int surplusdays) {
		this.surplusdays = surplusdays;
	}
	
}
