package ZUA.ys.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Description
 *
 * @author YS
 * @date 2020/11/19 19:39
 */
public class TransferCode {
    public static class Apple{
        String color;
        Integer weight;
        String getColor(){
            return color;
        }
        Integer getWeight(){
            return weight;
        }
        public static  boolean isGreenApple(Apple apple){
            return "green".equals(apple.getColor());
        }
        public static  boolean isHeavyApple(Apple apple){
            return apple.getWeight()>150;
        }
    }


    static List<Apple>  filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    static List<Apple>  filterApples(List<Apple> inventory, Predicate<Apple> p, Predicate<Apple> p1){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                if(p1.test(apple)) {
                    result.add(apple);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple();
        apple.color = "green";
        apple.weight = 149;
        apples.add(apple);
        Apple apple1 = new Apple();
        apple1.color = "red";
        apple1.weight = 151;
        apples.add(apple1);
        List<Apple> apples1 = filterApples(apples, Apple::isGreenApple);
        //apples1 = filterApples(apples, Apple::isHeavyApple);
        apples1 = filterApples(apples, Apple::isGreenApple,Apple::isHeavyApple);
        apples1 = filterApples(apples,(Apple a) -> "green".equals(a.getColor()));
        apples1 = filterApples(apples,(Apple a) -> "green".equals(a.getColor()) || a.getWeight()> 150);
        apples.stream().filter((Apple a) -> a.getWeight()>150).collect(Collectors.toList());
        apples.parallelStream().filter((Apple a)->a.getWeight()>150).collect(Collectors.toList());
        //apples1 = filter(apples,(Apple a)-> a.getWeight()> 150 );
        System.out.println(apples1.toString());
    }
}
