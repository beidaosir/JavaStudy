package cn.neusoft.util;

import java.security.SecureRandom;

public class GenerateUtils {

    private static SecureRandom secureRandom;

    static {
        secureRandom = new SecureRandom();
    }

    /**
     * 生成指定长度的随机验证码
     *
     * @param length 验证码长度
     * @return 随机验证码
     */
    public static String generateVerificationCode(int length) {
        StringBuilder verificationCode = new StringBuilder();

        // 定义数字和字符集合
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // 循环生成随机字符并追加到字符串中
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(chars.length());
            verificationCode.append(chars.charAt(randomIndex));
        }

        return verificationCode.toString();
    }

    /**
     * 生成指定长度的随机验证码
     *
     * @param length 验证码长度
     * @return 随机验证码
     */
    public static String generateNumberCode(int length) {
        StringBuilder verificationCode = new StringBuilder();

        // 定义数字和字符集合
        String chars = "0123456789";

        // 循环生成随机字符并追加到字符串中
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(chars.length());
            verificationCode.append(chars.charAt(randomIndex));
        }

        return verificationCode.toString();
    }

}
