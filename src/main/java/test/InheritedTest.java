package test;

/**
 * @author liu ping
 * @date 2020/5/9 10:06 上午
 */
public class InheritedTest {

    public static void main(String[] args) {
        SuperClass superClass = new SubClass();
        superClass.test();
    }


    static class SuperClass{

        public void say() {

        }

        public void test(){
            System.out.println("super class test");
            say();
        }
    }

    static class SubClass extends SuperClass {
        @Override
        public void say() {
            System.out.println("I am  sub class");
        }
    }


}
