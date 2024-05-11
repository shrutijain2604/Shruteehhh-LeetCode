class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double qSum = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] worker : workers) {
            maxHeap.offer(worker[1]);
            qSum += worker[1];

            if (maxHeap.size() > k)
                qSum -= maxHeap.poll();

            if (maxHeap.size() == k)
                minCost = Math.min(minCost, qSum * worker[0]);
        }

        return minCost;
    }
}