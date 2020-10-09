package com.thiethaa;

public class Main {
    //find missing number of:
    private static int[] arr = {4, 5, 3, 4, 2, 5, 1, 7, 4, 5, 2, 3, 4};
    private static int[] arr2 = {5, 5, 5, 6, 4, 4, 1, 3, 8, 1, 8};

    public static void main(String[] args) {
        //sorting
        System.out.println("sorting:");
        int n = arr.length;
        int n2 = arr2.length;
        System.out.println("arr:");
        int[] arrSort = sortArray(arr, n);
        for (int i : arrSort) {
            System.out.print(i + ",");
        }
        System.out.println("\narr2");
        int[] arr2Sort = sortArray(arr2, n2);
        for (int i : arr2Sort) {
            System.out.print(i + ",");
        }

        //remove duplicate
        System.out.println("\nremove duplicate:");
        System.out.println("arrSort:");
        int arrNoDupLen=removeDuplicate(arrSort, n);
        for(int i=0; i<arrNoDupLen;i++){
            System.out.print(arrSort[i]+",");
        }
        System.out.println("\narr2Sort:");
        int arr2NoDupLen=removeDuplicate(arr2Sort, n2);
        for(int i=0; i<arr2NoDupLen;i++){
            System.out.print(arr2Sort[i]+",");
        }


        //find missing number
        System.out.println("\nthe missing number are: ");
    }

    public static int[] sortArray(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] < a[j]) {
                    //swapping
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int removeDuplicate(int[] a, int n) {
        int[] temp = new int[n];
        int d = 0;
        for (int i = 0; i < n-1; i++) {
            if (a[i] != a[i + 1]) {
                temp[d++]=a[i];
            }
        }
        temp[d++]=a[n-1];
        for(int j=0; j<d;j++){
            //assign the uniq el to original array
            a[j]=temp[j];
        }
        return d;
    }
}
