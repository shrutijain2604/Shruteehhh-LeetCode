class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int richestPile = maxHeap.poll();
            maxHeap.offer((int) Math.sqrt(richestPile));
        }

        long totalGifts = 0;
        for (int gift : maxHeap) {
            totalGifts += gift;
        }

        return totalGifts;
    }
}