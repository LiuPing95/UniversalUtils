package test;

/**
 * @author liuping
 * @ClassName VolatileTest
 * @Description
 * @since 2023/2/9 21:45
 */
public class VolatileTest {

    public static void main(String[] args) {

        ShareVar shareVar = new ShareVar();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shareVar.setTask1(true);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shareVar.setTask2(true);
            }
        }).start();

        while (true) {
            if (shareVar.isTask1() && shareVar.isTask2()) {
                System.out.println("任务完成");
                break;
            }
        }

    }

    static class ShareVar {
        private volatile boolean task1;
        private volatile boolean task2;

        public boolean isTask1() {
            return task1;
        }

        public void setTask1(boolean task1) {
            this.task1 = task1;
        }

        public boolean isTask2() {
            return task2;
        }

        public void setTask2(boolean task2) {
            this.task2 = task2;
        }
    }


}
