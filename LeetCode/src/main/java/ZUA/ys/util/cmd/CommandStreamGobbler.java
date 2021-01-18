package ZUA.ys.util.cmd;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;

/**
 * Description
 * 执行shell命令
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


    CommandStreamGobbler(InputStream is, String command, String prefix) {
        this.is = is;
        this.command = command;
        this.prefix = prefix;
    }

    CommandStreamGobbler(InputStream is, String command, String prefix, String file) {
        this.is = is;
        this.command = command;
        this.prefix = prefix;
        this.file = file;
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
                if(!StringUtils.equals(prefix,"ERR")){
                    bufferedWriter.write(prefix+"\r\n");
                    bufferedWriter.write("执行命令："+command +"\r\n");
                }
            }

            while ((line = br.readLine()) != null) {
                infoRes.append(line);
                if (null != file) {
                    assert bufferedWriter != null;
                    if(!StringUtils.equals(prefix,"ERR")){
                        bufferedWriter.write( DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss  -  ")+line + "\r\n");
                        bufferedWriter.flush();
                    }
                }
            }
        } catch (IOException ioe) {
            success = false;
            logger.error("正式执行命令：" + command + "有IO异常");
        } finally {

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

