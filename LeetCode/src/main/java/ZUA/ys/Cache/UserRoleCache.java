package ZUA.ys.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author YS
 * @Creater 2020/8/31 14:51
 * Description 采用最近最少使用淘汰策略
 */
public class UserRoleCache<K,V> extends LinkedHashMap<K, V> implements Map<K, V> {

    private static final long serialVersionUID = 1L;

    public UserRoleCache(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    /**
     * @description 重写LinkedHashMap中的removeEldestEntry方法，当LRU中元素多余6个时，
     *              删除最不经常使用的元素
     * @author rico
     * @created 2017年5月12日 上午11:32:51
     * @param eldest
     * @return
     * @see LinkedHashMap#removeEldestEntry(Entry)
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        if(size() > 6){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        UserRoleCache<Character, Integer> userRoleCache = new UserRoleCache<Character, Integer>(
                16, 0.75f, true);

        String s = "abcdefg";
        for (int i = 0; i < s.length(); i++) {
            userRoleCache.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + userRoleCache.get('g'));
        System.out.println("LRU的大小 ：" + userRoleCache.size());
        System.out.println("UserRoleCache ：" + userRoleCache);
    }
}
