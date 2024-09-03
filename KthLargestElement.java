// Time Complexity : O(n)
// Space Complexity : O(log k) - min heap// max O(log (n-k))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Add the elements to minHeap PQ with size of k
// PQ will make sure to maintain the last k largest elements in Heap
// pq peek will have the kth largest element

public class KthLargestElement {

    public int findKthLargest2(int[] nums, int k) {

        //Using Max Heap
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue(
            new Comparator<Integer> () {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );

        for(int i =0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>n-k){
                result = Math.min(pq.poll(),result);
            }
        }

        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        
        //Using Min Heap
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i =0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
