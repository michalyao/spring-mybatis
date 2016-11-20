package springlearn.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Example {
  public static void main(String[] args) {
    MessagePrinter mp = new MessagePrinter();
    ProxyFactory pf = new ProxyFactory();
    pf.setTarget(mp);
    pf.addAdvice(new MessageDecorator());

    MessagePrinter proxy = (MessagePrinter) pf.getProxy();
    proxy.printMessage();
    System.out.println();
    mp.printMessage();

  }
}
