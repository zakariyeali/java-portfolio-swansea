import java.io.*; 
import java.util.*; 
public class RadixSort {

	public static int getMax(int arr[], int n) {
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx;		
	}

	public static int[] countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++){
            arr[i] = output[i];
        }
        return arr;
	}

	public static int[] radixsort(int arr[], int n){
		int m = getMax(arr, n);
		for (int exp = 1; m/exp > 0; exp *= 10) 
			countSort(arr, n, exp);
		return arr;
	}

		//test client
    public static void main(String args[] ) throws Exception {
		
		int K = Integer.parseInt(args[0]);
		int myArray[] = FastRead.FastReadArray(args[1]);
		int N = myArray.length;
		int[] sorted = radixsort(myArray, N);
		int i = 0;
		
		Stopwatch st = new Stopwatch();
		
		// ----- Your Code Here -----
		int xorsum = 0;
		// first K numbers of sorted array i.e. the lowest, if the array is in ascending order
		while (i < K) {
			xorsum = xorsum ^ myArray[i];
			i++;
		}
		//end while. set i to now equal the first K number of the largest K numbers in the sorted array. 
		i = N -K;
		while (i < N) {
			xorsum = xorsum ^ myArray[i];
			i++;
		}
		System.out.println(xorsum);
		// ----- Your Code Here -----		
		double time = st.elapsedTime();
		System.err.println("Elapsed Time: "+time+" s");			
	}

}