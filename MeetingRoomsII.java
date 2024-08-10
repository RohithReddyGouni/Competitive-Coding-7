//TC: O(nlogn)
//SC: O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min-heap to keep track of the end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first meeting's end time to the heap
        minHeap.add(intervals[0][1]);

        // Iterate over the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current meeting can reuse the earliest ending room
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();  // Remove the earliest ending meeting
            }

            // Add the current meeting's end time to the heap
            minHeap.add(intervals[i][1]);
        }

        // The size of the heap is the minimum number of rooms required
        return minHeap.size();
    }
}
