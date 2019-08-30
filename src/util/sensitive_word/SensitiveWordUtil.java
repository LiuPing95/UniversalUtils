package util.sensitive_word;

import java.util.*;

/**
 * @Description
 * @Author liuping
 * @Date 2019/8/1 10:11
 * @Version 1.0
 */
public class SensitiveWordUtil {

    public static void main(String[] args) {
        /*
        * 当前匹配规则
        * 1、第一匹配：只要检测到有敏感词，该条评论或者回复就失效。
        * 2、
        * */
        String words = "垃圾,乐色,屌毛,靓仔,嬲";
        String content = "你这游戏玩的真垃，乐色";
        addSensitiveWords(words);
        boolean hasSensitiveWord = hasSensitiveWord(content);
        System.out.println(hasSensitiveWord);

    }
    private static Map<Character, Set<String>> sensitiveWordMap = new HashMap<>();

    public static boolean hasSensitiveWord(String content) {
        if (content == null || "".equals(content)) {
            return false;
        }
        int contentLength = content.length();
        Set<String> sensitiveWordSet;
        for (int i = 0; i < contentLength; i++) {
            char key = content.charAt(i);
            sensitiveWordSet = sensitiveWordMap.get(key);
            if (sensitiveWordSet == null) {
                continue;
            } else if (sensitiveWordSet.isEmpty()) {
                // 匹配单个敏感字符
                return true;
            } else {
                // 匹配多个敏感字符
                for (String sensitiveWord : sensitiveWordSet) {
                    // TODO：目前是精准匹配，有需要可以添加模糊匹配
                    int wordLength = sensitiveWord.length();
                    if (contentLength - i < wordLength) {
                        // 如果剩下内容不够一个敏感词的长度
                        continue;
                    }
                    if (sensitiveWord.equals(content.substring(i, i + wordLength))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void addWord2Map(String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        char key = word.charAt(0);
        if (word.length() == 1) {
            sensitiveWordMap.put(key, Collections.emptySet());
        } else {
            Set<String> sensitiveWordSet = sensitiveWordMap.get(key);
            if (sensitiveWordSet != null) {
                sensitiveWordSet.add(word);
            } else {
                sensitiveWordMap.put(key, new HashSet<String>(){{add(word);}});
            }
        }
    }

    public static void addSensitiveWords(String words) {
        if (words != null && words.length() > 0) {
            String[] wordArr = words.split(",");
            for (String word : wordArr) {
                addWord2Map(word);
            }
        }
    }
}
