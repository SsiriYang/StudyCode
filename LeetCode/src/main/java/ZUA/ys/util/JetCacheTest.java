package ZUA.ys.util;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author YS
 * @date 2021/3/31 15:19
 */

public class JetCacheTest {
    private static Cache<Long, String> cache = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder()
            .limit(100)
            .expireAfterWrite(200, TimeUnit.SECONDS)
            .buildCache();

    public String getCache(Long id){
        return cache.get(id);
    }

    public void setCache(Long id,String count){
         cache.put(id,count);
    }

    public static void main(String[] args) {

        cache.put(1L,"1");
        cache.put(2L,"2");
        cache.put(2L,"3");
        System.out.println(cache.get(2L));
        System.out.println(cache.get(3L));
    }
}
