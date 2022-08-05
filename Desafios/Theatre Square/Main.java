import java.io.IOException;
import java.util.Scanner;

public class Main {
    // coded by
    // Breno Silva
    public static void main(String[] args)
        throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        Long n = scanner.nextLong();
        Long m = scanner.nextLong();
        Long a = scanner.nextLong();

        Long valueOne = n/a + calculatePieces(n,a);
        Long valueTwo = m/a + calculatePieces(m,a);

        Long result = valueOne * valueTwo;

        System.out.println(result);

        scanner.close();
    }


    public static Long calculatePieces(Long numberA, Long numberB){
        return Long.valueOf(restoDaDivisao(numberA, numberB) == 0 ? 0 : 1);
    }

    public static Long restoDaDivisao(Long a, Long b) {
        return a % b;
    }
}