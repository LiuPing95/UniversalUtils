package test;

/**
 * @author liuping
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    m1(j);
                    m2(j);
                }
            }).start();
        }




    }

    public static void m1(int i) {
        String s = "["+i+"]"+Thread.currentThread().getName();
        ThreadLocalContext.setObject(s);
        System.out.println("set :" +i +"----->"+s);
    }

    public static void m2(int i) {
        System.out.println("get :" +i +"----->"+ThreadLocalContext.getString());
    }
}
