package test.func;

/**
 * @author Liu Ping
 * @date 2021/11/1 8:14 PM
 */
@FunctionalInterface
public interface MyFunc<T> {

    void exec(T t);
}
