package ZUA.ys.util;

import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Description
 *
 * @author YS
 * @date 2020/12/14 11:51
 */
public class CommandStreamGobbler extends Thread {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CommandStreamGobbler.class);
    private InputStream is;

    private String command;

    private String prefix = "";

    private String file;

    private boolean readFinish = false;

    private boolean ready = false;

    private boolean success = true;

    private StringBuilder infoRes = new StringBuilder();

    private Boolean endFlag = false;

    CommandStreamGobbler(InputStream is, String command, String prefix) {
        this.is = is;
        this.command = command;
        this.prefix = prefix;
    }

    CommandStreamGobbler(InputStream is, String command, String prefix, String file, Boolean endFlag) {
        this.is = is;
        this.command = command;
        this.prefix = prefix;
        this.file = file;
        this.endFlag = endFlag;
    }

    @Override
    public void run() {
        InputStreamReader isr = null;
        BufferedWriter bufferedWriter = null;
        try {
            isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            ready = true;

            if (null != file) {
                bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            }

            while ((line = br.readLine()) != null) {
                infoRes.append(line);

                if (null != file) {
                    assert bufferedWriter != null;
                    bufferedWriter.write(command + "\r\n");
                    bufferedWriter.write(line + "\r\n");
                    bufferedWriter.flush();
                }
            }
        } catch (IOException ioe) {
            success = false;
            logger.error("正式执行命令：" + command + "有IO异常");
        } finally {
            //if (endFlag) {
                try {
                    if (isr != null) {
                        isr.close();
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException ioe) {
                    success = false;
                    logger.error("正式执行命令：" + command + "有IO异常");
                }
                readFinish = true;
           // }
        }
    }

    public InputStream getIs() {
        return is;
    }

    public String getCommand() {
        return command;
    }

    public boolean isReadFinish() {
        return readFinish;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean isSuccess() {
        return success;
    }

    public StringBuilder getInfoRes() {
        return infoRes;
    }
}

