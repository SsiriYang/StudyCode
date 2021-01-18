package ZUA.ys.util.cmd;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description
 *
 * @author YS
 * @date 2020/12/14 11:50
 */
public class ShellUtils {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ShellUtils.class);


    public static ExecResult runShell(String command,String prefix,String file) {
        InputStreamReader stdISR = null;
        InputStreamReader errISR = null;
        Process process = null;
        boolean success = true;
        Long timeout = 1L;
        ExecResult exeRes = new ExecResult();
        try {
            //String[] commands = {"/bin/sh","-c",command};
            String[] commands = {command};
            process = Runtime.getRuntime().exec(commands);

            CommandStreamGobbler errorGobbler = new CommandStreamGobbler(process.getErrorStream(), command, "ERR", file);
            CommandStreamGobbler outputGobbler = new CommandStreamGobbler(process.getInputStream(), command, prefix, file);

            errorGobbler.start();
            // 必须先等待错误输出ready再建立标准输出
            while (!errorGobbler.isReady()) {
                Thread.sleep(10);
            }
            outputGobbler.start();
            while (!outputGobbler.isReady()) {
                Thread.sleep(10);
            }
            Worker worker = new Worker(process);
            worker.start();
            try {
                worker.join(timeout);
                if (worker.exit != null){
                    int exitValue =worker.exit;
                } else{

                }
            } catch (InterruptedException ex) {
                worker.interrupt();
                Thread.currentThread().interrupt();
                throw ex;
            }
            //int exitValue = process.waitFor();
            exeRes.content = errorGobbler.getInfoRes().toString();
            success = errorGobbler.isSuccess() && outputGobbler.isSuccess();

        } catch (IOException | InterruptedException e) {
            success = false;
            logger.error("执行shell脚本报错"+file,e);
        } finally {
            try {
                if (stdISR != null) {
                    stdISR.close();
                }
                if (errISR != null) {
                    errISR.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                logger.error("正式执行命令：" + command + "有IO异常：" + e);
            }
        }
        exeRes.setResult(success);
        return exeRes;
    }

    private static class Worker extends Thread {
        private final Process process;
        private Integer exit;

        private Worker(Process process) {
            this.process = process;
        }
        @Override
        public void run() {
            try {
                exit = process.waitFor();
            } catch (InterruptedException ignore) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecResult res4 = ZUA.ys.util.cmd.ShellUtils.runShell("java -version","","C:\\Users\\41765\\Desktop\\AnyDmp\\123.txt");

    }
}
