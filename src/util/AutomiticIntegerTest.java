package util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author liu ping
 * @Version 1.x.0
 * @Description
 * @Date 2020/2/11 11:07 AM
 **/
public class AutomiticIntegerTest
{

    static AtomicInteger ai = new AtomicInteger(1);

    static int[] arr = new int[]{1, 3};

    static AtomicIntegerArray aia = new AtomicIntegerArray(arr);


    public static void main(String[] args)
    {
//        System.out.println(ai.getAndIncrement());
//        System.out.println(ai.get());
        // AtomicIntegerArray 不copy了一个数组 而不是直接用原来的数组
        aia.getAndSet(0, 5);
        ai.incrementAndGet();
        int andAdd = ai.getAndAdd(10);
        System.out.println(ai);
//        System.out.println(aia.get(0));
//        System.out.println(arr[0]);

    }
}
