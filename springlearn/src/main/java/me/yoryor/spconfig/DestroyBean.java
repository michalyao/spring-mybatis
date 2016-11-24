package me.yoryor.spconfig;

import org.springframework.beans.factory.DisposableBean;

public class DestroyBean implements DisposableBean {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void destroy() throws Exception {

    }
}
