import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A {


    public static void main(String[] args) {

      //  Reverse a String using java 8
        String input = "Nanjunda";
        String reversed = input.chars().mapToObj(c->String.valueOf((char)c)).reduce("",(a,b)->b+a);
        System.out.println("ReversedString : "+reversed);

// remove duplicates for the same string

     String dupRemv =   input.toLowerCase().chars().distinct()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
        System.out.println("DuplicateRemove : " +dupRemv);
// print the duplicates
        HashSet<Character> seen = new HashSet<>();
        Set<Character> printDuplicates = input.toLowerCase().chars().mapToObj(c->(char)c).filter(n->!seen.add(n)).collect(Collectors.toSet());
        System.out.println("printDuplicates :"+printDuplicates);

        // print no of occurances of each character
        Map<Character,Long> occurances = input.toLowerCase().chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("occurances : "+occurances);

     //Find first non repeating character
     Character firstNonRepeat = input.toLowerCase().chars().mapToObj(c->(char)c).filter(ch->input.indexOf(ch)==input.lastIndexOf(ch)).findFirst().orElse(null) ;
        System.out.println("firstNonRepeat : "+firstNonRepeat);

     //print unique characters

        Set<Character> uniqueChar = input.toLowerCase().chars().mapToObj(c->(char)c).filter(ch->input.indexOf(ch)==input.lastIndexOf(ch))
                .collect(Collectors.toSet());
        System.out.println("Unique Character : "+uniqueChar);

        // to maintain the order || because HashSet is not maintaning the insertion order
        Set<Character> uniqueChar1 = input.toLowerCase().chars().mapToObj(c->(char)c).filter(ch->input.indexOf(ch)==input.lastIndexOf(ch))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("uniqueChar1 :"+uniqueChar1);
    }

}
