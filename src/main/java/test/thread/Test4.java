package test.thread;

import java.util.ArrayList;

/**
 * @author liuping
 * @ClassName Test4
 * @Description
 * @since 2023/3/7 18:03
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            objects.add(new Object());
        }
        for (Object object : objects) {

        }
//        Iterator<Object> iterator = objects.iterator();
//        int i = 0;
//        while (iterator.hasNext()) {
//            i++;
//            if (i == 5 || i== 6) {
//                iterator.remove();
//                System.out.println(objects.size());
//            }
//
//            Object next = iterator.next();
//            System.out.println(next);
//        }
//        for (int i = 0; i < 10; i++) {
//            new Test4();
//        }
//        System.gc();
//        while (true) {
//            Thread.sleep(1000L);
//            System.gc();
//        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("回收");
    }
}
