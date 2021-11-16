package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author liuping
 * @Date 2019/8/22 9:18
 * @Version 1.0
 */
public class ListTest {

    public static Integer num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1:"+num);
            num = 1;

        }).start();


        new Thread(() -> {
            num = 2;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2:"+num);
        }).start();



    }
}
