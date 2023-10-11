package Week2;

import java.util.Arrays;

interface SortingAlgorithm
{
   void sort(int[] arr);
}
class BubbleSort implements SortingAlgorithm
{

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (arr[i - 1] > arr[i])
                {
                    // Swap arr[i-1] and arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}

class MergeSort implements SortingAlgorithm
{
    @Override
    public void sort(int[] arr)
    {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays leftArray[] and rightArray[]
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

// Implement the QuickSort class
class QuickSort implements SortingAlgorithm
{
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

public class Ques8 {
    public static void main(String[] args)
    {
        int[] arr = {5, 2, 9, 1, 5, 6};

        SortingAlgorithm bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println("Bubble Sort Result: " + Arrays.toString(arr));

        int[] arr2 = {5, 2, 9, 1, 5, 6};
        SortingAlgorithm mergeSort = new MergeSort();
        mergeSort.sort(arr2);
        System.out.println("Merge Sort Result: " + Arrays.toString(arr2));

        int[] arr3 = {5, 2, 9, 1, 5, 6};
        SortingAlgorithm quickSort = new QuickSort();
        quickSort.sort(arr3);
        System.out.println("Quick Sort Result: " + Arrays.toString(arr3));
    }
}
