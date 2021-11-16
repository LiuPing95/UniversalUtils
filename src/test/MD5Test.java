package test;

import java.security.MessageDigest;

/**
 * @author liu ping
 * @date 2021/8/4 下午11:04
 */
public class MD5Test {

    public static String GetMD5(String inputString) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = inputString.getBytes("UTF-8");
        byte[] array = md5.digest(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            if(Integer.toHexString(0xFF & b).length() == 1)
            {
                sb.append("0").append(Integer.toHexString(0xFF & b));
            }
            else {
                sb.append(Integer.toHexString(0xFF & b));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(GetMD5("Apple"));
    }


}
