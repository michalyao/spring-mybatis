package me.yoryor.spconfig;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 容器生命周期管理:
 * @PostConstruct -> 回调方法 -> init 方法
 * @PreDestroy
 */

public class SimpleBean implements InitializingBean, DisposableBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";

    private String name;
    private int age = Integer.MIN_VALUE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initialing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Set the age property");
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SimpleBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();
        ctx.registerShutdownHook();

        SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
        System.out.println(simpleBean1);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        System.out.println("calling destory");
        System.out.println("destory finished");
//        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
    }

    private static SimpleBean getBean(String simpleBean1, ApplicationContext ctx) {
        SimpleBean simpleBean = null;
        try {
            simpleBean = (SimpleBean) ctx.getBean(simpleBean1);
            System.out.println(simpleBean);
            return simpleBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init method by implementing InitializingBean");

    }

    public void mydestroy() {
        System.out.println("destroy by xml-method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory by interface");
    }
}
