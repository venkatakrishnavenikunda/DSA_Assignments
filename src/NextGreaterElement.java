import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {2,1,2,4,3};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: "+Arrays.toString(nextGreater(arr)));
    }
}
