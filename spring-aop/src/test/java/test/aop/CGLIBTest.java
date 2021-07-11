package test.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Title
 * @Author zzs
 * @Date 2021/7/12
 * @Description:
 */
public class CGLIBTest {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CGLIBTest.class);
		enhancer.setCallback(new MyMethodInterceptorImpl());

		CGLIBTest obj = (CGLIBTest)enhancer.create();
		obj.test1();
	}

	public void test1() {
		System.out.println("11111111111111111111");
	}
}

class MyMethodInterceptorImpl implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("before");

		Object re = methodProxy.invoke(o,objects);
		System.out.println("after");
		return re;
	}
}
