import java.util.*;
class prime_num
{
    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);
        int a,check=0;
        System.out.print("Enter a number to check prime or not : ");
        a = inp.nextInt();
        if(a==0 || a==1)
        {
            System.out.println(a+" is not a prime");
            check = 1;
        }
        else if(a>=2)
        {
            for(int i = 2 ; i<a ; i++)
            {
                if(a % i == 0)
                {
                    System.out.println(a+" is not a prime");
                    check = 1;
                    break;
                }
            }
        }
        else
        {
            System.out.println("Invalid input");
            check = 1;
        }
        if(check==0)
        {
            System.out.println(a+" is a prime");
        }
        inp.close();
    }
}
