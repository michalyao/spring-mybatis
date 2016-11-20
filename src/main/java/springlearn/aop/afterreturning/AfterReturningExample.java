package springlearn.aop.afterreturning;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import springlearn.aop.MessagePrinter;
import springlearn.aop.before.BeforeExample;

import java.lang.reflect.Method;

public class AfterReturningExample implements AfterReturningAdvice {
  public static void main(String[] args) {
    MessagePrinter target = new MessagePrinter();
    ProxyFactory pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvice(new AfterReturningExample());
    MessagePrinter proxy = (MessagePrinter) pf.getProxy();
    proxy.printMessage();
    System.out.println();
    System.out.println();
    target.printMessage();
  }


  public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
    System.out.println(method.getName());
    System.out.println(returnValue);
  }
}
