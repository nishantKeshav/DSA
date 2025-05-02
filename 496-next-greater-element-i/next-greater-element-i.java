class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 1st solution using numbers
        // HashMap<Integer , Integer> map = new HashMap<>();
        // Stack<Integer> stack = new Stack<Integer>();
        // for (int i = nums2.length - 1 ; i >= 0 ; i--) {
        //     int num = nums2[i];
        //     while(!stack.isEmpty() && stack.peek() <= num) {
        //         stack.pop();
        //     }
        //     if (stack.isEmpty()) {
        //         map.put(num , -1);
        //     } else {
        //         map.put(num , stack.peek());
        //     }
        //     stack.add(num);
        // }
        // // System.out.println(map);
        // for (int i = 0 ; i < nums1.length ; i++) {
        //     nums1[i] = map.get(nums1[i]);
        // }
        // return nums1;


        // 2nd Solution using Indexes
        HashMap<Integer , Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < nums2.length ; i++) {
            while(!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]) {
                int prevIdx = stack.pop();
                map.put(nums2[prevIdx] , nums2[i]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int index = stack.pop();
            map.put(nums2[index] , -1);
        }
        for (int i = 0 ; i < nums1.length ; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}