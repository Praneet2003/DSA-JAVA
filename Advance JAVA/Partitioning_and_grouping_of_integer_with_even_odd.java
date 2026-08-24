import java.util.*;
import java.util.stream.*;
class Partitioning_and_grouping_of_integer_with_even_odd{
    public static void main(String args[]){
        List<Integer> li = new ArrayList<>(Arrays.asList(10,11,12,13,14,17,16,18));
        Map<Boolean,List<Integer>> res = li.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println(res);
        // Map<String,List<Integer>> res1 = li.stream.collect(Collectors.groupingBy(n->n%2==0?"Even":"Odd"));
        // System.out.println(res1);
         li.stream().filter(n->n>12).peek(n->System.out.println("After peek "+ n)).map(n->n+2).forEach(System.out::println);
    }
}