package cn.zx.pojo;

public class EmailMessage {
    private Integer email_id;

    private String email_account;

    private String email_password;

    private String email_smtp_host;

    private String send_mail;

    private String rec_mail_account;

    private String rec_mail;

    private String subject;

    private String content;

    public Integer getEmail_id() {
        return email_id;
    }

    public void setEmail_id(Integer email_id) {
        this.email_id = email_id;
    }

    public String getEmail_account() {
        return email_account;
    }

    public void setEmail_account(String email_account) {
        this.email_account = email_account == null ? null : email_account.trim();
    }

    public String getEmail_password() {
        return email_password;
    }

    public void setEmail_password(String email_password) {
        this.email_password = email_password == null ? null : email_password.trim();
    }

    public String getEmail_smtp_host() {
        return email_smtp_host;
    }

    public void setEmail_smtp_host(String email_smtp_host) {
        this.email_smtp_host = email_smtp_host == null ? null : email_smtp_host.trim();
    }

    public String getSend_mail() {
        return send_mail;
    }

    public void setSend_mail(String send_mail) {
        this.send_mail = send_mail == null ? null : send_mail.trim();
    }

    public String getRec_mail_account() {
        return rec_mail_account;
    }

    public void setRec_mail_account(String rec_mail_account) {
        this.rec_mail_account = rec_mail_account == null ? null : rec_mail_account.trim();
    }

    public String getRec_mail() {
        return rec_mail;
    }

    public void setRec_mail(String rec_mail) {
        this.rec_mail = rec_mail == null ? null : rec_mail.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "EmailMessage [email_id=" + email_id + ", email_account="
				+ email_account + ", email_password=" + email_password
				+ ", email_smtp_host=" + email_smtp_host + ", send_mail="
				+ send_mail + ", rec_mail_account=" + rec_mail_account
				+ ", rec_mail=" + rec_mail + ", subject=" + subject
				+ ", content=" + content + "]";
	}
    
}