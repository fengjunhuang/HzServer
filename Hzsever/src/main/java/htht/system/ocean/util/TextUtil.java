package htht.system.ocean.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    public static boolean  isEmprty(String str){
        if(str!=null&&!str.isEmpty()){
            return false;
        }else {
            return true;
        }

    }
    public static String replaceBlank(String str) {

        String dest = "";

        if (str != null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }
        dest.replace("\\","");
        return dest;

    }
    public static String ClobToString(Clob clob) throws SQLException, IOException {

        String reString = "";
        java.io.Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }





}
