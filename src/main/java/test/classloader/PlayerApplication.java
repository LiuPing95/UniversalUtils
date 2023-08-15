package test.classloader;

/**
 * @author liuping
 * @ClassName PlayerApplication
 * @Description
 * @since 2022/10/11 11:12
 */
public class PlayerApplication {

    /**
     * 启动应用
     */
    public void start() {
        System.out.println("应用启动");
    }

    /**
     * 执行操作
     */
    public void exec() {
        System.out.println("执行操作1234567");
    }

    /**
     * 销毁应用
     */
    public void destroy() {
        System.out.println("应用销毁");
    }
}
