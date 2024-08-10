//TC: O(nlogn + klogn)
//SC: O(n) - Atmost we store one element per row at any moment.

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0; i < matrix.length; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        int i = 0;
        while(i < k - 1) {
            int[] indexElement = pq.poll();
            int element = indexElement[0];
            int row = indexElement[1];
            int column = indexElement[2];

            if(column + 1 < matrix.length) {
                pq.add(new int[]{matrix[row][column + 1], row, column + 1});
            }
            i++;
        }

        return pq.poll()[0];
    }
}
