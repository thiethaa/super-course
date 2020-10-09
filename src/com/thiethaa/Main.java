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
        //create new array to store uniq el
        int[]unique = new int[arrNoDupLen];
        for(int i=0; i<arrNoDupLen;i++){
            //assing uniq element to new array
            unique[i]=arrSort[i];
            System.out.print(arrSort[i]+",");
        }
        System.out.println("\narr2Sort:");
        int arr2NoDupLen=removeDuplicate(arr2Sort, n2);
        //create new array to store uniq el
        int[]unique2 = new int[arr2NoDupLen];

        for(int i=0; i<arr2NoDupLen;i++){
            //assing uniq element to new array
            unique2[i]=arr2Sort[i];
            System.out.print(arr2Sort[i]+",");
        }

        //find missing number on the uniq array
        System.out.println("\nthe missing number of uniq array is: ");
        int missNo=findOneMissingNo(unique,unique.length);
        System.out.println(missNo);

        System.out.println("\nthe missing number of uniq2 array is: ");
        int lastEl= unique2[unique2.length-1];
       findmultipleMissingNo(unique2,lastEl);

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

    public static int findOneMissingNo(int[]a,int n){
        //sumarize all the element then substract the total with the index
        int total = (n+1)*(n+2)/2;
        for(int i=0; i<n;i++){
            total-=a[i];
        }
       return total;
    }

    public static void findmultipleMissingNo(int[]a,int n){
        //create vektor array to mark present elemen
        boolean [] mark= new boolean[n+1];
        for(int i=0; i<a.length;i++){
            mark[a[i]]=true;
        }
        for(int j=1; j<n;j++){
            if(!mark[j]){
                System.out.print(j+",");
            }
        }
    }
}
