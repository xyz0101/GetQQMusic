package music.utils;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Utils {

    public static String getURLCollection(String address){
        String rtnLine = "";
        try{
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            InputStreamReader input = new InputStreamReader(in, "UTF-8");
            BufferedReader buffer = new BufferedReader(input);
            // nextLine = buf.readLine();
            String nextLine = "";
            while(( nextLine = buffer.readLine())!=null){
                rtnLine = rtnLine+nextLine;
                // System.out.println(nextLine);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();

        }
        return rtnLine;
    }


    /**
     *
     * @param inputUrl 资源下载路径
     * @param outputUrl 本地下载路径
     * @return
     */
    public static double downloadFile(String inputUrl, String outputUrl,String name) {
        double rtnNumber = 0.0;
        File file = null;
        try {
            // 统一资源
            URL url = new URL(inputUrl);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设置编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开连接
            httpURLConnection.connect();

            // 文件大小
            int fileLength = httpURLConnection.getContentLength();
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            file = new File(outputUrl);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream os = new FileOutputStream(file);
            int size = 0;
            int len = 0;
            byte[] buf = new byte[1024];
            while ((size = bis.read(buf)) != -1) {
                len += size;
                os.write(buf, 0, size);
                // 下载百分比
                // rtnNumber= len * 100 / fileLength*1.0;
                System.out.println(name+" 下载了-------> " + len * 100 / fileLength +
                        "%\n");
            }
            System.out.println(bis.read(buf));
            bis.close();
            os.close();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            return rtnNumber;
        }

    }
    /**
     *
     * @param inputUrl 资源下载路径
     * @param outputUrl 本地下载路径
     * @param name 资源名称
     * @param textField 绘制进度
     * @return
     */
    public static double downloadFileInGUI(String inputUrl, String outputUrl, String name, JTextField textField) {
        double rtnNumber = 0.0;
        File file = null;
        try {
            // 统一资源
            URL url = new URL(inputUrl);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设置编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开连接
            httpURLConnection.connect();

            // 文件大小
            int fileLength = httpURLConnection.getContentLength();
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            file = new File(outputUrl);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream os = new FileOutputStream(file);
            int size = 0;
            int len = 0;
            byte[] buf = new byte[1024];
            long bd = new Date().getTime();
            long ed = -1;
            while ((size = bis.read(buf)) != -1) {
                len += size;
                os.write(buf, 0, size);
                // 下载百分比
                // rtnNumber= len * 100 / fileLength*1.0;


//                if(ed-bd>=1000||ed-bd<0) {
//                    bd = new Date().getTime();
                    textField.setText(name + " ：下载中（" + len * 100 / fileLength + "%）");
//                System.out.println(name+" 下载了-------> " + len * 100 / fileLength +
//                        "%\n");
            //    }
                ed = new Date().getTime();

            }
            System.out.println(bis.read(buf));
            textField.setText(name+" ：下载完成（"+100+"%）");
            bis.close();
            os.close();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            return rtnNumber;
        }

    }
}
