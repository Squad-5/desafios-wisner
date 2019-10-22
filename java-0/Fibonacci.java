package br.com.aceleradev.main.firstweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	// public static void main(String[] args) {
	//	new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	//}
    public static void main(String[] args) {
        System.out.println(fibonacci());
        System.out.println(isFibonacci(233));
    }

	// @Desafio("Fibonacci")
    public static List<Integer> fibonacci() {
        Integer[] fibonacci = new Integer[14];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        recursiveFibonacci(13, fibonacci);

        return new ArrayList<Integer>(Arrays.asList(fibonacci));
    }

    // @Desafio("isFibonacci")
    public static Boolean isFibonacci(Integer number) {
        return fibonacci().contains(number);
    }

    public static Integer recursiveFibonacci(Integer index, Integer[] list) {
        if (list[index] == null) list[index] = recursiveFibonacci(index - 1, list) + recursiveFibonacci(index - 2, list);
        return list[index];
    }
}
