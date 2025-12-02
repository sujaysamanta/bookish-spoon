package com.ibm.code_pair.bookish_spoon;

/**
 * <h1>Trapping Rain Water</h1>
 *
 * <p>
 * Given <code>n</code> non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it can trap after raining.
 * </p>

 *
 * <h2>Input Example</h2>
 *
 * <pre>
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * </pre>
 *
 * <h2>Output</h2>
 *
 * <pre>
 * 6
 * </pre>
 *
 * <h2>Constraints</h2>
 * <ul>
 *     <li>1 ≤ height.length ≤ 20,000</li>
 *     <li>0 ≤ height[i] ≤ 100,000</li>
 * </ul>
 *
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater solver = new TrappingRainWater();
        int result = solver.trap(height);

        System.out.println("Trapped water = " + result);
    }

    /**
     * Two-pointer implementation of the Trapping Rain Water problem.
     *
     * @param height array representing elevation bars
     * @return total water trapped
     */
    private int trap(int[] height) {
        private static int trap(int[] arr) {

        int n = arr.length;
        if(n<=2) return 0;
        int[] prefix = new  int[n];
        int[] postfix = new int[n];

        //prefix traversal
        prefix[0] = arr[0];
        for(int i = 1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }


        postfix[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--) {
            postfix[i] = Math.max(postfix[i+1], arr[i]);
        }

        int result = 0;
        for(int i=1; i<n-1; i++) {
            result += Math.min(prefix[i], postfix[i]) - arr[i];
        }
        return result;
    }
    }
}

