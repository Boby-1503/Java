
public class Ques3
{

    public static void main(String[]args)
    {
        int [] arr1={3,5,7};
        int [] arr2={4,3,9};

        creatingArray(arr1,arr2);

    }
    static int FindingMaxElement(int[] arr1,int[] arr2,int i)
    {
        int maximumElement=0;

        if(arr1[i]>arr2[i])
        {
            maximumElement=arr1[i];
        }
        else
        {
            maximumElement=arr2[i];
        }
        return maximumElement;

    }

    static void creatingArray(int[]arr1,int[]arr2)
    {
        float [] newArr=new float[arr2.length];


        for(int i=0;i<arr2.length;i++)
        {

            newArr[i]= (FindingMaxElement(arr1,arr2,i) +(float) arr1[i]/arr2[i] );
        }
        System.out.println("New created array is: ");
        for(int i=0;i<arr2.length;i++)
        {
            System.out.println(newArr[i]);
        }
    }
}
