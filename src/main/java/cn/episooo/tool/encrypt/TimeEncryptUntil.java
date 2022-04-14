package cn.episooo.tool.encrypt;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.lang.String;
import java.lang.System;
public class TimeEncryptUntil {

    static class EncryptUntil {
        public static String encrypt(String time){
            StringBuilder sb = new StringBuilder();
            for(char c : time.toCharArray()){
                c = (char)(c+'A');
                sb.append(c);
            }
            return sb.toString();
        }
        public static String decrypt(String time){
            StringBuilder sb = new StringBuilder();
            for(char c : time.toCharArray()){
                sb.append((char)(c-'A'));
            }
            return sb.toString();
        }
    }
    public static String timeEncrypt(long time){
        String timeString = String.valueOf(time);
        String encryptTime = EncryptUntil.encrypt(timeString);
        return encryptTime;
    }
    public static long timeDecrypt(String time){
        String decryptTime = EncryptUntil.decrypt(time);
        long timeLong = Long.parseLong(decryptTime);
        return timeLong;
    }
}

