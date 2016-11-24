package springlearn.aop.pointcut;


import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class SimpleAdvice implements MethodInterceptor {
  public static void main(String[] args) {
    BeanOne target = new BeanOne();
    ProxyFactory pf = new ProxyFactory();
    Pointcut pc = new StaticMethodPointcutEx();
    Advice advice = new SimpleAdvice();
    Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    BeanOne proxyOne = (BeanOne) pf.getProxy();
    proxyOne.foo();
    System.out.println();
    proxyOne.bar();

  }

  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    System.out.println("Invoking " + methodInvocation.getMethod().getName());
    Object retVal = methodInvocation.proceed();
    System.out.printf("done");
    return retVal;
  }
}
