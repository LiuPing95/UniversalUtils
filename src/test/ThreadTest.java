package test;

import java.util.*;

/**
 * @author liu ping
 * @date 2021/5/17 下午5:07
 */
public class ThreadTest {

    public static final Map<String, String> map = new HashMap<>();


    public static void main(String[] args) {

        /*List<Object> list = new ArrayList<>();
        Object o;
        for (int i = 0; i < 10; i++) {
            o = new Object();
            list.add(o);
        }
        list.forEach(obj -> System.out.println(obj));*/

        List<Object> list = new ArrayList<>();
        System.out.println(list instanceof Collection);

    }
}
