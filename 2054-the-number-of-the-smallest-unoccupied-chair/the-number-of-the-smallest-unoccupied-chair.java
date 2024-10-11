class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> lst = new ArrayList<>();
        PriorityQueue<Integer> seat = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            lst.add(new int[] { times[i][0], times[i][1], i });
            seat.add(i);
        }
        Collections.sort(lst, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1])
                return a[2] - b[2];
            return a[1] - b[1];
        });

        for (int i = 0; i < lst.size(); i++) {
            int[] arr = lst.get(i);
            if (!pq.isEmpty() && arr[0] >= pq.peek()[1]) {
                while (!pq.isEmpty() && arr[0] >= pq.peek()[1]) {
                    int[] a = pq.poll();
                    if (a[2] == targetFriend)
                        return a[3];
                    seat.add(a[3]);
                }
                pq.add(new int[] { arr[0], arr[1], arr[2], seat.poll() });
            } else {
                pq.add(new int[] { arr[0], arr[1], arr[2], seat.poll() });
            }
        }
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (a[2] == targetFriend)
                return a[3];
        }
        return -1;
    }
}