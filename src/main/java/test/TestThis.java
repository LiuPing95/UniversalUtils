package test;

/**
 * @author liuping
 * @ClassName TestThis
 * @Description
 * @since 2022/10/21 16:23
 */
public class TestThis {



    static class OuterClass {
        final String str = "OuterClass";

        public InnerClass getInner() {
            return new InnerClass();

        }

        class InnerClass {
            final String str = "InnerClass";
            final String str2 = this.str;//指向内部类的域
            final String str3 = OuterClass.this.str;//指向外部类的域
        }



    }
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.getInner();
        System.out.println(innerClass.str);
        System.out.println(innerClass.str2);
        System.out.println(innerClass.str3);
    }
}
