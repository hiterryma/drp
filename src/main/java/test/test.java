package test;


import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args)throws Exception {
        Set<Long> sets=new HashSet<>();
        sets.add(1L);
        sets.add(2L);
        sets.add(3L);
        for(Long set:sets ){
            System.out.println(set);
        }
    }
}
