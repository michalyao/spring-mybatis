package me.yoryor.sppropeditor;

public class BeanExample {
    private Name name;

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Message{");
        sb.append("name=").append(name);
        sb.append('}');
        return sb.toString();
    }
}
