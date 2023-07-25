class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start_a = 0;
        int start_b = 0;
        int end_a = nums1.length - 1;
        int end_b = nums2.length - 1;
        int len = nums1.length + nums2.length;

        int k = len / 2;

        if( len % 2 == 0) {
            return (get_kth_element(nums1, nums2, k, start_a, end_a, start_b, end_b) 
            + get_kth_element(nums1, nums2, k-1, start_a, end_a, start_b, end_b)) / 2.0;
        } else {
            return get_kth_element(nums1, nums2, k, start_a, end_a, start_b, end_b);
        }
        
    }
    public int get_kth_element(int[] a, int[] b, int k, int start_a, int end_a, int start_b, int end_b ) {
        int len_a = end_a - start_a;
        int len_b = end_b - start_b;

        if(len_a < 0) {
            return b[k - start_a];
        }
        if(len_b < 0) {
            return a[k - start_b];
        }

        int index_a = start_a + len_a / 2;
        int index_b = start_b + len_b / 2;

        int med_a = a[index_a];
        int med_b = b[index_b];

        if(index_a + index_b < k) {
            if(med_a > med_b) {
                return get_kth_element(a, b, k, start_a, end_a, index_b + 1, end_b);
            } else {
                return get_kth_element(a, b, k, index_a + 1, end_a, start_b, end_b);
            }
        } else {
            if(med_a > med_b) {
                return get_kth_element(a, b, k, start_a, index_a - 1, start_b, end_b);
            } else {
                return get_kth_element(a, b, k, start_a, end_a, start_b, index_b-1);
            }
        }
    }
}