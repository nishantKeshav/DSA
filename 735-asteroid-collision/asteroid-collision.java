class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            while(!stack.isEmpty() && num < 0 && stack.peek() > 0) {
                int sum = num + stack.peek();
                if (sum < 0) {
                    stack.pop();
                } else if (sum > 0) {
                    num = 0;
                    break;
                } else {
                    stack.pop();
                    num = 0;
                }
            }
            if (num != 0) {
                stack.push(num);
            }
        }
        int ans[] = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }
        reverse(ans.length , ans);
        return ans;
    }

    public void reverse(int n , int arr[]) {
        int low = 0 , high = n - 1;
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}

// class Solution {
//     public int[] asteroidCollision(int[] arr) {
//         int n = arr.length;
        
//         Stack<Integer> s1 = new Stack<>(); // for +ve
//         Stack<Integer> s2 = new Stack<>(); // for -ve
//         ArrayList<Integer> list = new ArrayList<>();
//         boolean cond = true;
//         for (int i = 0 ; i < n ; i++) {
            
//             if (arr[i] > 0) {
//                 cond = false;
//                 s1.push(arr[i]);
//             } else {
//                 if (cond == false) {
//                     s2.push(-1 * arr[i]);
//                 } else {
//                     list.add(arr[i]);
//                 }
//             }
//             if (!s1.isEmpty() && !s2.isEmpty()) {
//                 while(!s1.isEmpty() && !s2.isEmpty()) {
//                     if (s2.peek() > s1.peek()) {
//                         s1.pop();
//                     } else if (s1.peek() > s2.peek()) {
//                         s2.pop();
//                     } else {
//                         s1.pop();
//                         s2.pop();
//                     }
//                 }
//             }
//             if (s1.isEmpty() && !s2.isEmpty()) {
//                 while(!s2.isEmpty()) {
//                     list.add(-1 * s2.pop());
//                 }
//             }
//         }
//         // System.out.println(s1);
//         // System.out.println(s2);
        
//         n = s1.size() + s2.size() + list.size();
//         int idx = 0;
//         int ans[] = new int[n];
        
//         while(!s1.isEmpty()) {
//             ans[idx++] = s1.pop();
//         }
//         while(!s2.isEmpty()) {
//             ans[idx++] = s2.pop() * -1;
//         }
//         reverse(n, ans);
//         for (int i = 0 ; i < list.size() ; i++) {
//             if (ans[i] == 0) {
//                 ans[i] = list.get(i);
//             }
//         }
//         return ans;
//     }

    // public void reverse(int n , int arr[]) {
    //     int low = 0 , high = n - 1;
    //     while(low < high) {
    //         int temp = arr[low];
    //         arr[low] = arr[high];
    //         arr[high] = temp;
    //         low++;
    //         high--;
    //     }
    // }
// }