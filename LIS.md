## [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/)
### Recursion
```java
  class Solution {
    int maxLen;
    public int lengthOfLIS(int[] nums) {
        find(nums, 0, Integer.MIN_VALUE, 0);
        return maxLen;
    }

    private void find(int[] nums, int i, int prev, int curLen) {
        if (i == nums.length) {
            if (maxLen < curLen) {
                maxLen = curLen;
            }
            return;
        }

        if (prev < nums[i]) 
            find(nums, i+1, nums[i], curLen + 1);
        find(nums, i+1, prev, curLen);
    }
  }
```

----

## [Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)
### Recursion
```java
  class Solution {
    int res, maxLen;
    public int findNumberOfLIS(int[] nums) {
        find(nums, 0, Integer.MIN_VALUE, 0);
        return res;
    }

    private void find(int[] nums, int i, int prev, int curLen) {
        if (i == nums.length) {
            if (maxLen < curLen) {
                maxLen = curLen;
                res = 1;
            }
            else if (maxLen == curLen) {
                res++;
            }
            
            return;
        }

        if (prev < nums[i]) 
            find(nums, i+1, nums[i], curLen + 1);
        find(nums, i+1, prev, curLen);
    }
  }
```
