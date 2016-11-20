package springlearn.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor {

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    System.out.print("Hello ");
    Object retVal = methodInvocation.proceed();
    System.out.print("!");
    return retVal;
  }
}
