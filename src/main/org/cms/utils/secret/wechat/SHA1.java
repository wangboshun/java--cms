package cms.utils.secret.wechat;

import java.security.MessageDigest;
import java.util.Arrays;

public class SHA1 {
    /**
     * 用SHA1算法生成安全签名
     * @param token 票据
     * @param timestamp 时间戳
     * @param nonce 随机字符串
     * @param encrypt 密文
     * @return 安全签名
     * @throws AesException
     */
    public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException
    {
        try {
            String[] array = new String[] { token, timestamp, nonce, encrypt };
            return sha1Comm(array);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }

    /**
     * 用SHA1算法生成安全签名
     * @param token 票据
     * @param timestamp 时间戳
     * @param nonce 随机字符串
     * @return 安全签名
     * @throws AesException
     */
    public static String getSHA1(String token, String timestamp, String nonce) throws AesException {
        try {
            String[] array = new String[] { token, timestamp, nonce};
            return sha1Comm(array);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }

    private static String  sha1Comm (String[] array ) throws Exception{
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes()); //加入数据
        byte[] digest = md.digest();

        return    MD5.byteArrayToHexString(digest);

    }
}
