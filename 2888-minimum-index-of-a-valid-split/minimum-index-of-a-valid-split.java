class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dom = getDom(nums);
        if (dom == -1) {
            return -1;
        }
        int totalDomElements = 0;
        int n = nums.size();
        for (int i = 0 ; i < n ; i++) {
            if (dom == nums.get(i)) {
                totalDomElements++;
            }
        }
        int leftDomElements = 0;
        for (int i = 0 ; i < n ; i++) {
            if (dom == nums.get(i)) {
                leftDomElements++;
            }
            int rightDomElements = totalDomElements - leftDomElements;
            if ((leftDomElements * 2 > (i + 1)) && (rightDomElements * 2 > (n - i - 1))) {
                return i;
            }
        }
        return -1;
    }

    public int getDom(List<Integer> nums) {
        int ele = nums.get(0);
        int count = 1;
        int n = nums.size();
        for (int i = 1 ; i < n ; i++) {
            if (count == 0) {
                ele = nums.get(i);
                count = 1;
            } else {
                if (ele == nums.get(i)) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0 ; i < n ; i++) {
            if (nums.get(i) == ele) {
                count++;
            }
        }
        return ((count * 2) > n) ? ele : -1; 
    }
}