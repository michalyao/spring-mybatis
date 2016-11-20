package springlearn.aop.before;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import springlearn.aop.MessagePrinter;

import java.lang.reflect.Method;

public class BeforeExample implements MethodBeforeAdvice {
  public static void main(String[] args) {
    MessagePrinter target = new MessagePrinter();
    ProxyFactory pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvice(new BeforeExample());
    MessagePrinter proxy = (MessagePrinter) pf.getProxy();
    proxy.printMessage();
    System.out.println();
    System.out.println();
    target.printMessage();
  }


  public void before(Method method, Object[] objects, Object o) throws Throwable {
    System.out.println(method.getName());
  }
}
