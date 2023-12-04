public class Exercise_2
{
    public static void main(String[] args)
    {
        int[] array={5,7,6,9,8,1,-15,2,6};
        int sizeOfArray=array.length;
        int sum= sumOfArray(array, sizeOfArray);
        calculateAverage(sum,sizeOfArray);
    }

    static int sumOfArray(int[] array,int sizeOfArray)
    {
        int sum=0;
        for(int i=0;i<sizeOfArray;i++)
        {
            sum+=array[i];
        }
        System.out.println("Sum is:"+sum);
        return sum;
    }
    static void calculateAverage(int sum,int sizeOfArray)
    {

        int average=sum/sizeOfArray;
        System.out.println("Average sum of the given arrays is: "+average);
    }
}

