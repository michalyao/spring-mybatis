package me.yoryor.spaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinter implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void someOperation() {
        System.out.println("Bean [" + beanName + "] - someOperation()");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        BeanNamePrinter printer = (BeanNamePrinter) ctx.getBean("beanNamePrinter");
        printer.someOperation();


        ctx.registerShutdownHook();

    }
}
