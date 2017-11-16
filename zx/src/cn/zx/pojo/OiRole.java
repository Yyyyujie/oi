package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class OiRole {
    private Integer o_r_id;

    private String name;

    private Integer status;

    private String rules;
    
    private List<Integer> rule=new ArrayList<Integer>();
    
    
    @Override
	public String toString() {
		return "OiRole [o_r_id=" + o_r_id + ", name=" + name + ", status=" + status + ", rules=" + rules + ", rule="
				+ rule + "]";
	}

	public List<Integer> getRule() {
		return rule;
	}

	public void setRule(List<Integer> rule) {
		this.rule = rule;
	}

	public Integer getO_r_id() {
        return o_r_id;
    }

    public void setO_r_id(Integer o_r_id) {
        this.o_r_id = o_r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }
}