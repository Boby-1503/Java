public class Ques2
{
    public static void main(String[] args)
    {
        int[] array={5,7,6,9,8,1,-15,2,6};

        int sizeOfArray=array.length;  //To find the size of array

        int sum= sumOfArray(array, sizeOfArray); //Storing the sum of array in a variable named sum.

        calculateAverage(sum,sizeOfArray);  //calling the function named calculateAverage

    }

    static int sumOfArray(int[] array,int sizeOfArray) //making a int function which will return the sum of array and passing the arguments as array and sizeOfArray
    {
        int sum=0;

        for(int i=0;i<sizeOfArray;i++)
        {
            sum+=array[i];
        }

        System.out.println("Sum is:"+sum);

        return sum;
    }
    static void calculateAverage(int sum,int sizeOfArray) //making a function which will calculate average sum of array
    {

        int average=sum/sizeOfArray;  //Applying formula of calculate average

        System.out.println("Average sum of the given arrays is: "+average);

    }
}
