
import java.util.HashMap;
import java.util.Map;





public class TestQAlg {
	public static int something (int arr[]) {
	int N = arr.length;
	int tmp = -1;
   	int max = 0;
	for (int i=0; i < N-2; i++) {
		for (int j= 0; j < i-2; j++) {
			//C1: O(n2)
			max = arr[i] * arr[j] * arr[j+1];
		}
		tmp = arr[i]*arr[i+1]*arr[i+2];
		if (tmp > max);
		max = tmp;
		}
      return max;
	}

	public static void somethingnewer(int A[], int B)
	{
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i!=j) && (A[i] + A[j] == B)) {
					System.out.println("("+i+","+j+")");
					return;
				}
			}
		}
		System.out.println("(-1,-1)");
	}

	public static void somethingBetter(int A[], int B)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < A.length; i++)
		{
			if(map.containsKey(B-A[i]))
			{
				System.out.println("Pair found at index " + map.get(B-A[i]) + "," + i);
				return;
			}
			// store index of current element in the map
			map.put(A[i], i);
		}
		System.out.println("(-1,-1)");
	}

	// driver 
	public static void main(String[] args) {
		TestQAlg test = new TestQAlg();
		int [] arr = {1,4,6,9,10,11,16};
		int B = Integer.parseInt(args[0]);
		int max = something(arr);
		System.out.println("Maximum of three highest array values multiplied is : ");
		System.out.println(max);
		Stopwatch st = new Stopwatch();
		System.out.println("And the following indices if they can be added to get B, other wise -1-1, ");
		test.somethingnewer(arr, B);
		double time = st.elapsedTime();
		System.out.println("Elapsed time: "+ time +" s");
		/*------------------------------------------------*/
		System.out.println("And my version!");
		test.somethingBetter(arr, B);
		double time2 = st.elapsedTime() - time;
		System.out.println("Elapsed time: "+time2 + " s");
	}

}