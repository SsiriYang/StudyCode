package ZUA.ys.Thread;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
/**

 * 文件下载管理类

 */

public class DownLoadManager {

    /**

     * 每个线程下载的字节数

     */

    static final long unitSize = 1000 * 1024;



    /**

     * 启动多个线程下载文件

     */

    public void doDownload(String remoteFileUrl)

            throws IOException {



        String fileName = new URL(remoteFileUrl).getFile();

        fileName = fileName.substring(fileName.lastIndexOf("/")+1,fileName.length()).replace("%20", " ");



        long fileSize = this.getRemoteFileSize(remoteFileUrl);



        if(fileSize == 0){

            return;

        }



        this.createFile(fileName, fileSize);



        long threadCount = fileSize / unitSize;

        System.out.println("共启动 "

                + (fileSize % unitSize == 0 ? threadCount : threadCount + 1)

                + " 个线程");



        long offset = 0;

        if (fileSize <= unitSize) {// 如果远程文件尺寸小于等于unitSize

            DownloadThread downloadThread = new DownloadThread(remoteFileUrl,

                    fileName, offset, fileSize);

            downloadThread.start();

        } else {// 如果远程文件尺寸大于unitSize

            for (int i = 1; i <= threadCount; i++) {

                DownloadThread downloadThread = new DownloadThread(

                        remoteFileUrl, fileName, offset, unitSize);

                downloadThread.start();



                offset = offset + unitSize;

            }

            if (fileSize % unitSize != 0) {// 如果不能整除，则需要再创建一个线程下载剩余字节

                DownloadThread downloadThread = new DownloadThread(

                        remoteFileUrl, fileName, offset, fileSize

                        - unitSize * threadCount);

                downloadThread.start();



            }

        }



    }



    /**

     * 获取远程文件尺寸

     */

    private long getRemoteFileSize(String remoteFileUrl) throws IOException {



        long fileSize = 0;

        HttpURLConnection httpConnection = (HttpURLConnection) new URL(

                remoteFileUrl).openConnection();



        httpConnection.setRequestMethod("HEAD");



        int responseCode = httpConnection.getResponseCode();

        if(responseCode >= 400){

            System.out.println("Web服务器响应错误!");

            return 0;

        }



        String sHeader;

        for(int i=1;;i++){

            sHeader = httpConnection.getHeaderFieldKey(i);

            if(sHeader != null && sHeader.equals("Content-Length")){

                System.out.println("文件大小ContentLength:"+httpConnection.getContentLength());

                fileSize = Long.parseLong(httpConnection.getHeaderField(sHeader));

                break;

            }

        }



        return fileSize;

    }



    /**

     * 创建指定大小的文件

     */

    private void createFile(String fileName, long fileSize) throws IOException {

        File newFile = new File(fileName);

        RandomAccessFile raf = new RandomAccessFile(newFile, "rw");



        raf.setLength(fileSize);



        raf.close();

    }



}



/**

 * 负责文件下载的类

 */

class DownloadThread extends Thread {

    /**

     * 待下载的文件

     */

    private String url = null;



    /**

     * 本地文件名

     */

    private String fileName = null;



    /**

     * 偏移量

     */

    private long offset = 0;



    /**

     * 分配给本线程的下载字节数

     */

    private long length = 0;



    /**

     * @param url 下载文件地址

     * @param offset 本线程下载偏移量

     * @param length 本线程下载长度

     *

     * @author Angus.wang

     * */

    public DownloadThread(String url, String file, long offset, long length) {

        this.url = url;

        this.fileName = file;

        this.offset = offset;

        this.length = length;

        System.out.println("偏移量=" + offset + ";字节数=" + length);

    }



    @Override
    public void run() {

        try {

            HttpURLConnection httpConnection = (HttpURLConnection) new URL(

                    this.url).openConnection();



            httpConnection.setRequestMethod("GET");

            httpConnection.setRequestProperty("RANGE", "bytes=" + this.offset

                    + "-" + (this.offset + this.length - 1));



            System.out.println("RANGE bytes=" + this.offset + "-" + (this.offset + this.length - 1));



            BufferedInputStream bis = new BufferedInputStream(httpConnection

                    .getInputStream());



            byte[] buff = new byte[1024];

            int bytesRead;

            File newFile = new File(fileName);

            RandomAccessFile raf = new RandomAccessFile(newFile, "rw");





            while ((bytesRead = bis.read(buff, 0, buff.length)) != -1) {

                raf.seek(this.offset);

                raf.write(buff, 0, bytesRead);



                this.offset = this.offset + bytesRead;

            }



            raf.close();

            bis.close();

        } catch (IOException ioe) {

            ioe.printStackTrace();

        }



    }



}





/**

 * 多线程文件下载测试

 * */

class FileDownloadTest {

    /**

     * @param args

     */

    public static void main(String[] args) {

        try{

            //String remoteFileUrl = "http://dl.maxthon.cn/cn/mx2/mx_2.5.1.4751cn.exe";
            String remoteFileUrl = "https://github-releases.githubusercontent.com/92443980/d8efd600-76ca-11eb-8be9-ac49b741ca33?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20210225%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20210225T054430Z&X-Amz-Expires=300&X-Amz-Signature=46666c6448247b3fae87dea1a4acb30472ac54341b6ff8260f685d4f40d7db57&X-Amz-SignedHeaders=host&actor_id=0&key_id=0&repo_id=92443980&response-content-disposition=attachment%3B%20filename%3Ddraw.io-14.4.3-windows-installer.exe&response-content-type=application%2Foctet-stream";


            DownLoadManager downLoadManager = new DownLoadManager();



            downLoadManager.doDownload(remoteFileUrl);

        }catch(Exception e){

            e.printStackTrace();

        }

    }



}