class Solution {
    public int reversePairs(int[] nums) {
        class Utils {
            void merge(int[] array, int[] tempArray, int low, int mid, int high) {
                int start1 = low;
                int end1 = mid;
                int start2 = mid + 1;
                int end2 = high;
                int k = low;
                while (start1 <= end1 && start2 <= end2) {
                    if (array[start1] < array[start2]) {
                        tempArray[k] = array[start1];
                        start1++;
                    } else {
                        tempArray[k] = array[start2];
                        start2++;
                    }
                    k++;
                }
                while (start1 <= end1) {
                    tempArray[k] = array[start1];
                    start1++;
                    k++;
                }
                while (start2 <= end2) {
                    tempArray[k] = array[start2];
                    start2++;
                    k++;
                }
                for (k = low; k <= high; k++) {
                    array[k] = tempArray[k];
                }
            }

            int mergeSort(int[] array, int[] tempArray, int low, int high) {
                if (low >= high) {
                    return 0;
                }
                int mid = (low + high) / 2;
                int count = mergeSort(array, tempArray, low, mid) + mergeSort(array, tempArray, mid + 1, high);
                for (int i = low, j = mid + 1; i <= mid; i++) {
                    while (j <= high && nums[i] / 2.0 > nums[j]) {
                        j++;
                    }
                    count += j - (mid + 1);
                }
                merge(array, tempArray, low, mid, high);
                return count;
            }
        }
        Utils utils = new Utils();
        return utils.mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }
}