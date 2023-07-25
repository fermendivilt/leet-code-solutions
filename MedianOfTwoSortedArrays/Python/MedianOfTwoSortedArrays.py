class Solution:
    def findMedianSortedArrays(self, a: List[int], b: List[int]) -> float:
        start_a = start_b = 0
        end_a = len(a) - 1
        end_b = len(b) -1
        length = len(a) + len(b)
        k = length // 2
        
        # When the length of the merged array is even, take the mean of the two
        # central values, otherwise, take the central value
        if length % 2==0:
            return (self.get_kth_element(a, b, k - 1, start_a, end_a, start_b, end_b) 
                    + self.get_kth_element(a, b, k, start_a, end_a, start_b, end_b)) / 2
            
        else:
            return self.get_kth_element(a, b, k, start_a, end_a, start_b, end_b)

    def get_kth_element(self, a, b, k, start_a, end_a, start_b, end_b):

        len_a = end_a - start_a
        len_b = end_b - start_b

        # If one array is empty, return the number in the other array
        if len_a < 0: 
            return b[k - start_a]
        if len_b < 0: 
            return a[k - start_b]

        # Central element of the current subsection of the array
        index_a = start_a + len_a//2
        index_b = start_b + len_b //2

        # Get the central number of each array
        med_a, med_b = a[index_a], b[index_b]

        
        if index_a + index_b < k: # the kth element is in the second half of the combined array
            if med_a > med_b:
                return self.get_kth_element(a, b, k, start_a, end_a, index_b + 1, end_b)
            else:
                return self.get_kth_element(a, b, k, index_a + 1, end_a, start_b, end_b)
        else: # the kth element is in the first half of the combined array
            if med_a > med_b:
                return self.get_kth_element(a, b, k, start_a, index_a - 1, start_b, end_b)
            else:
                return self.get_kth_element(a, b, k, start_a, end_a, start_b, index_b - 1)