import java.util.Scanner;
public class letter_and_word 
{
    
    void vowel(String word)
    {
        byte num = 0 ;
        int l = word.length();
        for(int i = 0 ; i<l ; i++) 
        {
            char letter = word.charAt(i);
            if(letter == 'a' || letter == 'e'|| letter == 'i'|| letter == 'o'|| letter == 'u')
            {
                num++;
            }
        }
        System.out.println("Number of vowels in "+word+" : "+num);
    }

    void consonants(String word)
    {
        int num = 0,l = word.length();
        for(int i = 0 ; i<l ; i++) 
        {
            char letter = word.charAt(i);
            if(letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u')
            {
                num++;
            }
        }
        System.out.println("Number of consonants in "+word+" : "+num);
    }

    int m_letter(String word,char letter)
    {
        byte check = 0;
        int l = word.length();
        for(int i = 0 ; i<l ; i++)
        {
            char compare = word.charAt(i);
            if(letter == compare)
            {
                check = 1;
                break;
            }
        }
        return check;
    }

    void anagrams(String word1 , String word2)
    {
        byte check = 0;
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == l2)
        {
            int l = l1 = l2;
            for(int i = 0 ; i<l ; i++)
            {
                for(int j = 0 ; j<l ; j++)
                {
                    char c1 = word1.charAt(i) , c2 = word2.charAt(j);
                    if(c1 == c2)
                    {
                        check++;
                        break;
                    }
                }
            }
            if(check == l1 && check == l2)
            {
                System.out.println(word1+" and "+word2+" was argrams");
            }
            else
            {
                System.out.println(word1+" and "+word2+" was't anagrams");
            }
        }
        else
        {
            System.out.println(word1+" and "+word2+" was't anagrams");
        }
    }

    int count_letter(String word , char letter)
    {
        byte count = 0;
        int l = word.length();
        for(int i = 0 ; i<l ; i++)
        {
            char lr = word.charAt(i);
            if(letter == lr)
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Eneter a word : ");
        String word = input.nextLine();
        int loop = 0;
        for(int z = 1 ; z<4 ; z++)
        {
            System.out.println("Choose the option ");
            System.out.println("\t1. Count vowels \n"
                            +"\t2. Count consonants \n"
                            +"\t3. Maching letter \n"
                            +"\t4. Check anagrams \n"
                            +"\t5. Count a letter");
            System.out.print("Enter the option : ");
            char option = input.next().charAt(0);

            letter_and_word obj = new letter_and_word(); 
            switch(option)
            {
                case '1':
                    obj.vowel(word);
                    break;

                case '2':
                    obj.consonants(word);
                    break;
                
                case '3':
                    System.out.print("Enter a letter : ");
                    char letter = input.next().charAt(0);
                    int x = obj.m_letter(word, letter);
                    if(x == 0)
                    {
                        System.out.println("NO, letter "+letter+" is't present in "+word);
                    }
                    else if(x==1)
                    {
                        System.out.println("YES, Letter "+letter+" present in "+word);
                    }
                    break;
                
                case '4':
                    System.out.print("Enter a word : ");
                    String w = input.next();
                    obj.anagrams(word, w);
                    break;

                case '5':
                    System.out.print("Enter a letter : ");
                    char ltr = input.next().charAt(0);
                    int count = obj.count_letter(word, ltr);
                    System.out.println("Count of "+ltr+" in "+word+" : "+count);
                    break;
                
                default:
                    System.out.println("Wrong option");
                    loop = 1;
                    break;
            }
            if(loop == 0)
            {
                break;
            }
        }
        input.close();
    }
}
