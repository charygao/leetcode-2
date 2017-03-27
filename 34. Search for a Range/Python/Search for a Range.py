class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        def search(nums, target):
            low = 0
            high = len(nums) - 1
            while low <= high:
                mid = (low + high) // 2
                if nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return low

        if not nums:
            return [-1, -1]
        low = search(nums, target)
        high = search(nums, target + 1)
        high -= 1
        if low < len(nums) and nums[low] == target:
            return [low, high]
        return [-1, -1]
