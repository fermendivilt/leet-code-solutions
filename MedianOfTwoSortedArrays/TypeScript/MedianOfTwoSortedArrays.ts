function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let start_a = 0;
    let start_b = 0;
    let end_a = nums1.length - 1;
    let end_b = nums2.length - 1;
    let len = nums1.length + nums2.length;

    let k = Math.floor(len / 2);

    if( len % 2 == 0) {
        return (get_kth_element(nums1, nums2, k, start_a, end_a, start_b, end_b) 
        + get_kth_element(nums1, nums2, k-1, start_a, end_a, start_b, end_b)) / 2.0;
    } else {
        return get_kth_element(nums1, nums2, k, start_a, end_a, start_b, end_b);
        }
};

function get_kth_element(a:number[], b:number[], k:number, start_a:number, end_a:number, start_b:number, end_b:number): number {
    let len_a = end_a - start_a;
    let len_b = end_b - start_b;

    if(len_a < 0) {
        return b[k - start_a];
    }
    if(len_b < 0) {
        return a[k - start_b];
    }

    let index_a = start_a + Math.floor(len_a / 2);
    let index_b = start_b + Math.floor(len_b / 2);

    let med_a = a[index_a];
    let med_b = b[index_b];

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
};