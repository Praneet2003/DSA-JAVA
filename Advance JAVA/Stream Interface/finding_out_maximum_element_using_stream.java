import java.util.*;
import java.util.stream.*;
class finding_out_maximum_element_using_stream{
    public static void main(String args[]){
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(12,23,45,21,17));
        OptionalInt large = li.stream().mapToInt(n->n).max();
        OptionalInt large1 = li.stream().mapToInt(n->n).filter(n->n>50).max();// optinal int can store a null value as well.
        System.out.println(large);
        System.out.println(large1);
        // // System.out.println(large.get());
        int res = li.stream().mapToInt(n->n).filter(n->n>50).max().orElse(0);
        System.out.println(res);
        int small = li.stream().mapToInt(n->n).min().orElse(0);
        System.out.println(small);
        double avg = li.stream().mapToInt(n->n).average().orElse(0);
        System.out.println("Average: "+avg);
        // int sum = li.stream().reduce(0,(a,b)->a+b);
        // System.out.println(sum);
        List<String> names = new ArrayList<>(Arrays.asList("Ramesh","Amit","Harish","Ashok"));
        String res1 = names.stream().reduce("",(a,b)->a+b);
        System.out.println(res1);
        double avg1 = li.stream().reduce(0,(a,b)->a+b);
        System.out.println(avg1/li.size());
        // //fetch first name from the list.
        String firstname = names.stream().findFirst().orElse("No Name");
        System.out.println(firstname);
        // firstname which starts with a.
        String firstnamestartswithA = names.stream().filter(n-> n.startsWith("A")).findFirst().orElse("No Name");
        System.out.println(firstnamestartswithA); 
        //convert every name to upper case.
        names = names.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
        System.out.println(names);
        // camelcase firstchar to upper and rest to lower
        names.set(0,"anshu");
        System.out.println(names);
        names = names.stream().map(n-> Character.toUpperCase(n.charAt(0))+n.substring(1).toLowerCase()).collect(Collectors.toList());
        System.out.println(names);
        // // find the second largest element from a list.
        // int secondlargest = li.stream().sorted(Comparator.reverseOrder());
        //print only first 3 elements
        li.stream().limit(3).forEach(System.out::print);
        li.stream().skip(3).forEach(System.out::print);
    }
}