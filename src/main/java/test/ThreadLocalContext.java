package test;

//import cn.hutool.core.bean.BeanUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author liuping
 */
public class ThreadLocalContext {

    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<>();

    public static void setObject(Object t) {
        THREAD_LOCAL.set(t);
    }

//    public static <T> T getObject(Class<T> cls) {
//        return THREAD_LOCAL.get() == null ? null : BeanUtil.copyProperties(THREAD_LOCAL.get(), cls);
//    }

    public static String getString() {
        return THREAD_LOCAL.get() == null ? null : String.valueOf(THREAD_LOCAL.get());
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("https://www.baidu.com", "UTF-8");
        System.out.println(encode);
    }

}
