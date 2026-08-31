import java.util.*;
// import java.util.stream.*;
class Get_Even_number_from_list{
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,12,34,21,45));
        System.out.println("Even Elements of the List: ");
        li.stream().filter(n->n%2==0).forEach(System.out::println);//filter is intermediate and forEach is terminate operator.
        System.out.println("\n Even elements greater than 5, using 2 filter().");
        li.stream().filter(n->n%2==0).filter(n->n>5).forEach(System.out::println);
        System.out.println("\n Even elements greater than 5, using logical operator.");
        li.stream().filter(n->(n%2==0 && n>5)).forEach(System.out::println);

    }
}