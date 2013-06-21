package com.xyp.codesnippet.vm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Method area out of memory method area (PermGen) consist of class info and
 * runtime constant pool In this case, create lots of classes using cglib then
 * PermGenOOM
 *
 * @author Peter Xu
 *
 */
public class MethodAreaOOM {

    /**
     * @param args Vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MethodAreaOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method,
                        Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }
}
