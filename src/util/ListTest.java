package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author liuping
 * @Date 2019/8/22 9:18
 * @Version 1.0
 */
public class ListTest
{

    public static void main(String[] args)
    {

        List<Integer> list = new ArrayList<>();
        while (list.size() < 10) {
            list.add(1);
        }
        list.add(5,5);
        for (Integer integer : list)
        {
            System.out.println(integer);
        }
    }
}
