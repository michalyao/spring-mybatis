package springlearn.aop.pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class StaticMethodPointcutEx extends StaticMethodMatcherPointcut {

  @Override
  public ClassFilter getClassFilter() {
    return new ClassFilter() {
      public boolean matches(Class<?> aClass) {
        return aClass == BeanOne.class;
      }
    };
  }

  public boolean matches(Method method, Class<?> aClass) {
    return (method.getName().equals("foo"));
  }
}
