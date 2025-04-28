class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        // Find median
        int median = findKthLargest(nums, (n + 1) / 2);

        int left = 0, i = 0, right = n - 1;

        // Virtual Index Mapping
        while (i <= right) {
            int mappedIndex = mapIndex(i, n);
            if (nums[mappedIndex] > median) {
                swap(nums, mapIndex(left++, n), mappedIndex);
                i++;
            } else if (nums[mappedIndex] < median) {
                swap(nums, mapIndex(right--, n), mappedIndex);
            } else {
                i++;
            }
        }
    }

    private int mapIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, storeIndex++, i);
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
