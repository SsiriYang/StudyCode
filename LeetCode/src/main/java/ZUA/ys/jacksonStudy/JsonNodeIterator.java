package ZUA.ys.jacksonStudy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @Author YS
 * @Creater 2020/10/13 20:47
 * Description
 */
public class JsonNodeIterator {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("E:\\IDEAWorkSpace\\StudyCode\\LeetCode\\src\\main\\java\\ZUA\\ys\\jacksonStudy\\query_range.json");
        JsonNode jsonNode = objectMapper.readValue(file,JsonNode.class);
        Iterator<String> fieldNames = jsonNode.fieldNames();
        while(fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            System.out.println("1:"+fieldName);
            JsonNode field = jsonNode.get(fieldName);
            if("data".equals(fieldName)){
                Iterator<String> fieldInnerNames = field.fieldNames();
                while (fieldInnerNames.hasNext()){
                    String fieldInnerName = fieldInnerNames.next();
                    System.out.println("2:"+fieldInnerName);
                }

            }
        }
    }
}
