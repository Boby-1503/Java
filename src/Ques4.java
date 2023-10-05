import java.util.Scanner;

public class Ques4
{
    public static void main(String[] args)
    {
        System.out.println("Enter string: ");

        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();

        int lengthOfString=calculatingLength(s);

        System.out.println("The length of string is: "+lengthOfString);


    }
    static int calculatingLength(String s)
    {
        int count=0;

        for(char ch:s.toCharArray())  //using foreach loop to iterate each character in given string 's'
        {
            if(ch != '\0')  //until ch not equal to null value
            {
               count++;   //count increases
            }

            else
                break; //otherwise break the loop
        }

        return  count;
    }
}
