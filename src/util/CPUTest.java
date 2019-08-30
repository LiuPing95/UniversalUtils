package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author liuping
 * @Date 2019/8/15 15:27
 * @Version 1.0
 */
public class CPUTest {

    public static void main(String[] args) {
        newThread();
        newThread();
        newThread();
        newThread();
        newThread();
        newThread();
    }

    public static void newThread(){
        new Thread(() -> {
            Map<String, Object> map = new HashMap<>();
            while (true) {
                map.put(new Object().toString(), new Object());
            }
        }).start();
    }
}
