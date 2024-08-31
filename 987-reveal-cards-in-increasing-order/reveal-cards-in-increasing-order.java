class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!list.isEmpty()) {
                list.addFirst(list.removeLast());
            }
            list.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[i] = list.removeFirst();
        }
        return result;
    }
}