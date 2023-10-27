public class Pivotkey {

    static int findPivot(int[] a , int st , int end){
        if(end < st) return -1;

        int mid = st + (end - st)/2;
        if(mid < end && a[mid] > a[mid+1]){
            return mid +1;
        }
        else if(mid > st && a[mid] < a[mid - 1]){
            return mid;
        }
        else if (a[mid] >= a[st]){
            return findPivot(a, mid+1,end);
        }
        else {
            return findPivot(a,st,mid-1);
        }
    }
    static int binarySearch(int[] a , int st , int end , int key){


        while (st<=end){
            int mid = st + (end - st)/2;
            if(key== a[mid]){
                return mid;
            }
            if(key > a[mid]){
                st = mid +1;
            }
            else{
                end = mid -1;
            }




        }
        return -1;
    }
    static int pivotedBinarySearch(int[] a , int n , int key){
        int Pivot = findPivot(a,0,n-1);

        if(Pivot == -1){
           return binarySearch(a,0,n-1,key);
        }

        if(a[Pivot] == key){
            return Pivot;
        }
        if(key >= a[0]){
            return binarySearch(a,0,Pivot -1 ,key);
        }
        else {
           return binarySearch(a,Pivot + 1 , n-1,key);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };//8
        int n = arr1.length;
        int key = 3;
        System.out.println(
                "Index of the element is : "
                        + pivotedBinarySearch(arr1, n, key));
    }
}
