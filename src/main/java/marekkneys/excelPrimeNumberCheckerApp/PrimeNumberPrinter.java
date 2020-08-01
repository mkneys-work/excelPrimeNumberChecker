package marekkneys.excelPrimeNumberCheckerApp;

import org.apache.commons.math3.primes.Primes;

import java.util.List;

public class PrimeNumberPrinter {
    public static void printAllPrimeNumbersInList(List<Integer> potentialPrimeNumbers){
        for(int number : potentialPrimeNumbers){
            if (Primes.isPrime(number))
            {
                System.out.println(number);
            }
        }
    }
}
