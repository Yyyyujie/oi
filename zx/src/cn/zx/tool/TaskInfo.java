package cn.zx.tool;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;

public class TaskInfo {
	private CompanyTask companyTask;
	private CompanyStaffer publisher;
	private CompanyStaffer receiver;
	
	public CompanyTask getCompanyTask() {
		return companyTask;
	}
	public void setCompanyTask(CompanyTask companyTask) {
		this.companyTask = companyTask;
	}
	public CompanyStaffer getPublisher() {
		return publisher;
	}
	public void setPublisher(CompanyStaffer publisher) {
		this.publisher = publisher;
	}
	public CompanyStaffer getReceiver() {
		return receiver;
	}
	public void setReceiver(CompanyStaffer receiver) {
		this.receiver = receiver;
	}

	
	
}
