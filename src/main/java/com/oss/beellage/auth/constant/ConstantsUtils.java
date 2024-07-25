package com.oss.beellage.auth.constant;

public class ConstantsUtils {
    public static final Integer RANDOM_NUMBER_START = 100000;
    public static final Integer RANDOM_NUMBER_RANGE = 900000;
    public static final String MAIL_AUTH_TITLE = "Beellage 이메일 인증";
    public static final String GMAIL_POSTFIX = "gmail.com";
    public static final String ENCODING = "UTF-8";

    public static String createGoogleAuthMail(String code) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <style>\n"
                + "            body { font-family: Arial, sans-serif; margin: 0; padding: 0; width: 100%; height: 100%; }\n"
                + "            .email-container { width: 100%; max-width: 600px; margin: 0 auto; border: 1px solid #dddddd; border-radius: 10px; overflow: hidden; }\n"
                + "            .header { background-color: #ffffff; padding: 20px; text-align: center; border-bottom: 1px solid #dddddd; }\n"
                + "            .header img { width: 50px; height: 50px; }\n"
                + "            .header h2 { margin: 0; font-size: 24px; }\n"
                + "            .content { background-color: #f4f4f4; padding: 20px; text-align: center; }\n"
                + "            .content h3 { margin: 20px 0 10px; font-size: 20px; }\n"
                + "            .content p { margin: 10px 0; font-size: 14px; color: #555555;}\n"
                + "            .code { letter-spacing: 5px; background-color: #fac83e; padding: 10px; margin-top: 10px; border-radius: 5px; font-size: 18px; font-weight: bold; display: inline-block; }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"background-color: #f4f4f4; padding: 20px 0;\">\n"

                + "            <tr>\n"
                + "                <td align=\"center\">\n"
                + "                    <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"600\" class=\"email-container\">\n"
                + "                        <tr>\n"
                + "                            <td class=\"header\">\n"
                + "                                <img src=\"https://cdn-icons-gif.flaticon.com/16939/16939737.gif\" alt=\"이미지\">\n"
                + "                                <h2>Beellage</h2>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                        <tr>\n"
                + "                            <td class=\"content\">\n"
                + "                                <h3>이메일 인증을 진행해주세요!</h3>\n"
                + "                                <p>아래의 인증 코드를 사용하여 인증을 완료하세요:</p>\n"
                + "                                <div class=\"code\">" + code + "</div>\n"
                + "                                <p>인증번호의 유효기간은 3분입니다.</p>\n"
                + "                            </td>\n"
                + "                        </tr>\n"
                + "                    </table>\n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>";
    }

    public static String createAuthMail(String code) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <style>\n"
                + "            body { font-family: Arial, sans-serif; margin: 0; padding: 0; width: 100%; height: 100%; }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body style='font-family: Arial, sans-serif; margin: 0; padding: 0; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center;'>\n"
                + "        <div style='width: 100%; max-width: 500px; margin: 0 auto; border: 1px solid #dddddd; border-radius: 10px; overflow: hidden;'>\n"
                + "            <div style='background-color: #ffffff; padding: 20px; text-align: center; border-bottom: 1px solid #dddddd;'>\n"
                + "                <img src='https://cdn-icons-gif.flaticon.com/16939/16939737.gif' alt='이미지' style='width: 50px; height: 50px;'>\n"
                + "                <h2 style='margin: 0; font-size: 24px;'>Beellage</h2>\n"
                + "            </div>\n"
                + "            <div style='background-color: #f4f4f4; padding: 20px; text-align: center;'>\n"
                + "                <h3 style='margin: 20px 0 10px; font-size: 20px;'>이메일 인증을 진행해주세요!</h3>\n"
                + "                <p style='margin: 10px 0; font-size: 14px; color: #555555;'>아래의 인증 코드를 사용하여 인증을 완료하세요:</p>\n"
                + "                <div style='letter-spacing: 5px; background-color: #fac83e; padding: 10px; margin-top: 10px; border-radius: 5px; font-size: 18px; font-weight: bold; display: inline-block;'>"
                + code + "</div>\n"
                + "                <p style='margin: 10px 0; font-size: 14px; color: #555555;'>인증번호의 유효기간은 3분입니다.</p>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>";
    }
}
