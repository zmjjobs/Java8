package com.zmj.test;

import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;

public class TestAnnotation {
	@Test
	public void test() {
		Class<TestAnnotation> clazz = TestAnnotation.class;
		Method showMethod = null;
		try {
			showMethod = clazz.getMethod("show");
			MyAnnotation[] myAnnotations = showMethod.getAnnotationsByType(MyAnnotation.class);
			for (MyAnnotation myAnnotation : myAnnotations) {
				//会打印注解的值 Spring  SpringMVC
				System.out.println(myAnnotation.value());
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

	@MyAnnotation("Spring")
	@MyAnnotation("SpringMVC")
	public void show(@MyAnnotation("my") String str) {
	}
}

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations{
	MyAnnotation[] value();
}

//@Repeatable 支持重复注解
@Repeatable(MyAnnotations.class)
//TYPE_PARAMETER  类型注解，注解到方法的参数上
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
	String value() default "abc";
}
