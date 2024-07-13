import java.util.Scanner;
public class Fibonacci_Series 
{
    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);
        int a = 0 , b = 1;
        System.out.print("Enter the length of fibonacci series : ");
        int n = inp.nextInt();
        if(n>=1)
        {
            System.out.print(a);System.out.print(" ");
        }
        if(n>=2)
        {
        System.out.print(b);System.out.print(" ");
        }
        for(int i = 3 ; i<=n ; i++)
        {
            int f = a + b;
            System.out.print(f);
            System.out.print(" ");
            a = b;
            b = f;
        }
        inp.close();
    }
}
