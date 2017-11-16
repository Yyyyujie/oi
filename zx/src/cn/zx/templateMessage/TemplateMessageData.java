package cn.zx.templateMessage;

public class TemplateMessageData {

    private String value;

    private String color = "#173177";

    private TemplateMessageData() {
    }

    public TemplateMessageData(String value) {
        this.value = value;
    }

    public TemplateMessageData(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
