import java.util.Scanner;
public class Digits_and_word 
{
    static void digit(String word,byte option)
    {
        String sub = "";
        int l = word.length();
        int sum = 0 ;
        for(int i = 0 ; i<l ; i ++)
        {
            char c=word.charAt(i);
            if(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'||c=='0')
            {
                int num = ((int)c) - '0';
                if(option == 1)
                {
                    System.out.print(num+" ");
                }
                else if(option == 3)
                {
                    sum+=num;
                }
                else if(option == 4 && num % 2 == 0)
                {
                    System.out.print(num+" ");
                }
                else if(option == 5 && num % 2 != 0)
                {
                    System.out.print(num+" ");
                }
            }
            else
            {
                if(option == 2)
                {
                    sub+=c;
                }
            }
        }
        if(option == 2)
        {
            System.out.println(sub);
        }
        else if(option == 3)
        {
            System.out.println(sum);
        }
    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String sentence = input.nextLine();
        System.out.println("\nChoose the option : "
                            +"\n\t1. Show only the numbers\n"
                            +"\t2. Show only the alphabets\n"
                            +"\t3. Sum of numbers\n"
                            +"\t4. Show only even numbers \n"
                            +"\t5. Show only odd number");
        byte loop = 0;
        for(int i = 1 ; i<4 ; i++)
        {
            System.out.print("\nEnter your option (1/2/3/4/5) : ");
            byte option = input.nextByte();
            
            switch(option)
            {
                case 1:
                    System.out.print("\nNumbers is the sentence("+sentence+") : ");
                    digit(sentence,option);
                    break;
                case 2:
                    System.out.print("\nSentence("+sentence+") without numbers : ");
                    digit(sentence,option);
                    break;
                case 3:
                    System.out.print("\nSum of the numbers in the sentence("+sentence+") : ");
                    digit(sentence,option);
                    break;
                case 4:
                    System.out.print("\nEven numbers in the sentence("+sentence+") : ");
                    digit(sentence, option);
                    break;
                case 5:
                    System.out.print("\nOdd numbers in the sentence("+sentence+") : ");
                    digit(sentence, option);
                    break;

                default:
                    System.out.println("Wrong option");
                    loop = 1;
            }
            if(loop == 0)
            {
                input.close();
                break;
            }
        }
    }
}
