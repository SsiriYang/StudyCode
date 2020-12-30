package ZUA.ys.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description
 *
 * @author YS
 * @date 2020/10/21 14:44
 */
public class TestCache {

    /**
     * 缓存大小
     */
    static int cacheSize = 5;

    private static Map<String, String> userRoleCache = new LinkedHashMap<String,String>(16, 0.75F, true){
        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
            if(size() > cacheSize){
                return true;
            }
            return false;
        }
    };

    public static void cleanCache(String userName){
        userRoleCache.keySet().removeIf(key -> key.equals(userName));
        userRoleCache.clear();
    }

    public static void main(String[] args) {
        userRoleCache.put("1","demo");
        userRoleCache.put("2","demo");
        userRoleCache.put("3","demo");
        userRoleCache.put("4","demo");
        userRoleCache.put("5","demo");
        userRoleCache.put("6","demo");
        System.out.println(userRoleCache.get("2"));
        TestCache.cleanCache("2");
        System.out.println(userRoleCache.get("2"));
    }
}
