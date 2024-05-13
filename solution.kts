class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val na = nums1.size
        val nb = nums2.size
        val n = na + nb

        if (n % 2 == 0) {
            return (
                solve(nums1, nums2, 0, na - 1, 0, nb - 1, n.floorDiv(2) - 1) +
                solve(nums1, nums2, 0, na - 1, 0, nb - 1, n.floorDiv(2))
            ) / 2.0
        } else {
            return solve(nums1, nums2, 0, na - 1, 0, nb - 1, n.floorDiv(2)).toDouble()
        }
    }

    fun solve(A: IntArray, B: IntArray, startA: Int, endA: Int, startB: Int, endB: Int, k: Int): Int{
        if (startA > endA) {
            return B[k - startA]
        }
        if (startB > endB) {
            return A[k - startB]
        }
 
        val indexA = (endA + startA).floorDiv(2)
        val indexB = (endB + startB).floorDiv(2)
 
        val valueA = A[indexA]
        val valueB = B[indexB]
 
        if (k > (indexA + indexB)) {
            if (valueA <= valueB) {
                return solve(A, B, indexA + 1, endA, startB, endB, k)
            } else {
                return solve(A, B, startA, endA, indexB + 1, endB, k)
            }
        } else {
            if (valueA <= valueB) {
                return solve(A, B, startA, endA, startB, indexB - 1, k)
            } else {
                return solve(A, B, startA, indexA - 1, startB, endB, k)
            }
        }
    }
}