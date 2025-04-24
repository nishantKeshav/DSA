class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int num : derived) {
            xor = xor ^ num;
        }
        return xor == 0;
    }
}

// class Solution {
//     public boolean doesValidArrayExist(int[] derived) {
//         int n = derived.length;
//         if (n == 1) {
//             if (derived[0] == 0)
//                 return true;
//             else
//                 return false;
//         }
//         if (derived[0] == 1) {
//             return check(derived , 0 , 1) || check(derived , 1 , 0);
//         } else { // 0
//             return check(derived , 0 , 0) || check(derived , 1 , 1);
//         }
//         // return false; // dead Condition
//     }
//     public boolean check(int arr[] , int val1 , int val2) {
//         int n = arr.length;
//         int start = val1;
//         int end = val2;
//         for (int i = 1 ; i < n - 1 ; i++) {
//             if (arr[i] == 0) {
//                 if (end == 1) {
//                     end = 1;
//                 } else {
//                     end = 0;
//                 }
//             } else {
//                 if (end == 1) {
//                     end = 0;
//                 } else {
//                     end = 1;
//                 }
//             }
//         }
//         // System.out.println(Arrays.toString(temp));
//         // return false;
//         return (arr[n-1] == (start ^ end));
//     }
// }