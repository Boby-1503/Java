import java.util.*;

public class Ques1
{
    public static void main(String[] args)
    {
        System.out.println("Enter the size of array: ");

        Scanner sc=new Scanner(System.in);  //To read input
        int sizeOfArray=sc.nextInt(); //To take integer input from user

        int[] array=new int[9];   //Creating array with size 9

        System.out.println("Enter the elements of an array: ");

        for(int i=0;i<sizeOfArray;i++)
        {
            array[i]=sc.nextInt();   //To insert elements in array
        }

        printArray(array,sizeOfArray);  //Calling the printArray function
        sumOfArray(array,sizeOfArray);  //Calling the sumOfArray function

    }
    static void printArray(int[] array,int sizeOfArray )  //Making a function which will help to print the elements of array when it will be called.
    {
        System.out.println("The elements of array are: ");

        for(int i=0;i<sizeOfArray;i++)
        {
            System.out.println(array[i]);
        }
    }
    static void sumOfArray(int[] array,int sizeOfArray)
    {
        int sum=0;  //Initialized the value of sum to zero

        for(int i=0;i<sizeOfArray;i++)
        {
            sum+=array[i];    //sum=sum+array[i]-- it will keep adding elements to its sum as long as it satisfy the condition i.e i<sizeofArray.
        }

        System.out.print("The sum of array is: "+sum);  //then it will print the value of sum
    }
}
