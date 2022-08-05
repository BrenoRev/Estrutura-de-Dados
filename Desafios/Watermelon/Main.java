import java.io.IOException;
import java.util.Scanner;

public class Main {
    // coded by
    // Breno Silva
    public static void main(String[] args)
        throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        int weightWaterMellong = scanner.nextInt();
        String result = isAbleToDivide(weightWaterMellong) ? "YES" : "NO";
        System.out.print(result);
        scanner.close();
    }


    public static boolean isAbleToDivide(int number){
        // Exceptional case when 2 / 2 = 1 ( odd ) 
        return number % 2 == 0 && number != 2;
    }

}