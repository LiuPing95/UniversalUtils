package test;

import java.io.*;

/**
 * @author liuping
 * @ClassName SerializableTest
 * @Description
 * @since 2022/10/28 18:02
 */
public class SerializableTest {


    static class MyInputStream extends InputStream {

        @Override
        public int read() throws IOException {
            return 0;
        }
    }

    static class MyOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        byte[] bytes1 = new Info().toString().getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        OutputStream objectOutputStream = new ByteArrayOutputStream();
        objectOutputStream.write(bytes1);
        objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        MyInputStream myInputStream = new MyInputStream();
        myInputStream.read(bytes1);
        OutputStream outputStream = new MyOutputStream();
    }

    static class Info/* implements Serializable*/ {

    }


}
