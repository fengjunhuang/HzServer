package htht.system.ocean.util;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ReadFileUtil {


    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[256];
            int byteread = 0;
            in = new FileInputStream(fileName);
            ReadFileUtil.showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
            System.out.println();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLinesForJson(String fileName) {
        File file = new File(fileName);

        BufferedReader reader = null;
        String s = "";
        try {
            String fileEncode=EncodingDetect.getJavaEncode(fileName);

            System.out.println("以行为单位读取文件内容，一次读一整行：");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), fileEncode);
            reader = new BufferedReader(isr);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
                s=s+tempString;
            }

            s=TextUtil.replaceBlank(s);
            System.out.println( tempString);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return  s;
    }

    /**
    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String s="";
      /*  try {
            System.out.println("以字符为单位读取文件内容，一次读一个字符：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file),"GBK");
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            System.out.println();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
   try {
       byte[] head = new byte[3];
       InputStream inputStream = new FileInputStream(fileName);

       String fileEncode=EncodingDetect.getJavaEncode(fileName);

       System.out.println("以字符为单位读取文件内容，一次读多个字符：");
            // 一次读多个字符
            char[] tempchars = new char[2000];

            int charread = 0;
       reader = new InputStreamReader(new FileInputStream(fileName),fileEncode);
//


            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')){

                System.out.print(tempchars);
                s= s+    new String(tempchars);
                }else{
                    for(int i = 0; i < charread; i++){
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            char a=(tempchars[i]);
                            s= s+    tempchars[i];
                            System.out.print(tempchars[i]);

                        }
                    }
                }
            }
     s=TextUtil.replaceBlank(s)+"]}";
       reader.close();
       file.delete();
   } catch (Exception e1) {
            try {
                reader.close();
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
            e1.printStackTrace();
        }
        finally {
       try {
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       file.delete();
   }
        return s;
    }
    public static boolean isUTF8(String key){
                try {
                     key.getBytes("utf-8");
                      return true;
                    } catch (UnsupportedEncodingException e) {
                         return false;
                     }
             }
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String s = "";
        try {
            String fileEncode=EncodingDetect.getJavaEncode(fileName);

            System.out.println("以行为单位读取文件内容，一次读一整行：");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), fileEncode);
            reader = new BufferedReader(isr);
            String tempString = null;

            StringBuffer sb=new StringBuffer();
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                sb.append(tempString+"\n");
                line++;

            }
            s=sb.toString();
            s=TextUtil.replaceBlank(s)+"]}";
            System.out.println( tempString);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return  s;
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 6) ? 6 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1){
                System.out.write(bytes, 0, byteread);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\upload\\1526031627410海域权属数据.zip.geojosn";
        readFileByLines(fileName);

   /*    ReadFileUtil.readFileByBytes(fileName);
        ReadFileUtil.readFileByLines(fileName);
        ReadFileUtil.readFileByRandomAccess(fileName);*/
    }


    /**
     * 得到JSONObject里的所有key
     * @param jsonObject JSONObject实例对象
     * @return Set
     */
    public static Set<String> getAllKeys(JSONObject jsonObject) {
        return getAllKeys(jsonObject.toString());
    }

    /**
     * 从JSON字符串里得到所有key
     * @param jsonString json字符串
     * @return Set
     */
    public static Set<String> getAllKeys(String jsonString) {
        Set<String> set = new HashSet<>();
        //按照","将json字符串分割成String数组
        String[] keyValue = jsonString.split(",");
        for(int i=0; i<keyValue.length; i++) {
            String s = keyValue[i];
            //找到":"所在的位置，然后截取
            int index = s.indexOf(":");
            //第一个字符串因带有json的"{"，需要特殊处理
            if(i==0) {
                set.add(s.substring(2, index-1));
            } else {
                set.add(s.substring(1, index-1));
            }
        }
        return set;
    }

}
