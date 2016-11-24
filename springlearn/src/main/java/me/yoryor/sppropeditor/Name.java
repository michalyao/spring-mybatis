package me.yoryor.sppropeditor;

public class Name {
    private String first;
    private String last;

    public Name() {
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Name{");
        sb.append("first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
