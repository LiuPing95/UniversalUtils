package test;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liu ping
 * @date 2020/5/13 11:05 上午
 */
public class EnumSwitchTest {


    public static void main(String[] args) {
        System.out.println(String.format("平台最多支持同时激活%s个村庄！", 50));
        /*TestEnum testEnum = TestEnum.B;
        switch (testEnum) {
            case A:
                System.out.println("A");
            case B:
                System.out.println("B");
            case C:
                System.out.println("C");
            case D:
                System.out.println("D");
                break;
            case E:
                System.out.println(2);
                break;
            default:
                System.err.println(3);
        }*/
    }


    static enum TestEnum {
        A, B, C, D, E
    }

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Test11 {
        String value();
    }

    static class Test22 {

        public static void main(String[] args) throws Exception {
            Test22 test22 = new Test22();
            Annotation[] annotations = test22.getClass().getMethod("testMethod", null).getAnnotations();
            for (Annotation annotation : annotations) {
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
                Field field = invocationHandler.getClass().getDeclaredField("memberValues");
                field.setAccessible(true);
                @SuppressWarnings("unchecked")
                Map<String, String> value = (LinkedHashMap<String, String>) field.get(invocationHandler);
                System.out.println(value.get("value"));
            }
        }

        @Test11(value = "apple")
        public void testMethod() {

        }
    }
}
