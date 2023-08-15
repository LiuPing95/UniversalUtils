package test;

/**
 * @author liuping
 * @ClassName ThreadJoinTest
 * @Description
 * @since 2022/4/8 17:50
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        thread.start();
        // 让线程等待一段时间
        thread.join(1000);
        System.out.println("ok");

    }
}
