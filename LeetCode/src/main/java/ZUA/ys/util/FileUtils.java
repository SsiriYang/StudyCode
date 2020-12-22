package ZUA.ys.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    /**
     * 判断文件夹是否存在
     * @param FilePath : 文件路径
     * @return : java.lang.Boolean
     **/
    private static   Boolean decideFileExit(String FilePath){
        File file = new File(FilePath);
        //用来测试此路径名表示的文件或目录是否存在
        if (!file.exists()) {
            file.mkdirs();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        decideFileExit("/Users/admin/Desktop/JrxWorkSpace/construct/abc/123.log");
    }
}
