package top.coolidea.security.demo.error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularJudgment {

    /**
     * 手机号正则
     */
    static String PHONE = "^1[3456789]\\d{9}$";

    static String CARD = "^[0-9]*$";

    /**
     * 邮箱正则
     */
    static String EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";


    /**
     * 身份证正则
     */
    static String IDCARD = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";


    /**
     * 样品组成及描述,工艺要求添加验证
     */
    static String DESANDREQ = "^\\d+$";

    static String IP = "(?=(\\b|\\D))(((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{1,2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))";

    /**
     * 手机号正则判断
     *
     * @param number
     * @return
     */
    public boolean IncorrectPhoneNumber(String number) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile(PHONE);
            Matcher matcher = p.matcher(number);
            flag = matcher.matches();
        } catch (Exception ee) {
            flag = false;
        }
        return flag;
    }


    /**
     * 密码正则判断
     *
     * @param passWord
     * @return
     */
    public boolean IncorrectPassWord(String passWord) {
        if (passWord.length() >= 6) {
            return true;
        }
        return false;
    }


    /**
     * 邮箱正则判断
     *
     * @param email
     * @return
     */
    public boolean IncorrectEmail(String email) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile(EMAIL);
            Matcher matcher = p.matcher(email);
            flag = matcher.matches();
        } catch (Exception ee) {
            flag = false;
        }
        return flag;
    }


    /**
     * 身份证正则判断
     *
     * @param idCard
     * @return
     */
    public boolean IncorrectIdCard(String idCard) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile(IDCARD);
            Matcher matcher = p.matcher(idCard);
            flag = matcher.matches();
        } catch (Exception ee) {
            flag = false;
        }


        return flag;
    }


    public boolean IncorrectCard(String cardno) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile(CARD);
            Matcher matcher = p.matcher(cardno);
            flag = matcher.matches();
        } catch (Exception ee) {
            flag = false;
        }
        return flag;
    }


    public boolean desAndreq(String des) {
        boolean flag = true;
        if (des.length() > 10) {
            try {
                Pattern p = Pattern.compile(DESANDREQ);
                Matcher matcher = p.matcher(des);
                flag = matcher.matches();
            } catch (Exception ee) {
                flag = true;
            }
        }
        return flag;
    }


    public boolean ipAdress(String ip) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile(IP);
            Matcher matcher = p.matcher(ip);
            flag = matcher.matches();
        } catch (Exception ee) {
            flag = false;
        }
        return flag;
    }
}
