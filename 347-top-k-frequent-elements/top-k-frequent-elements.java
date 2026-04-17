class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer > map = new HashMap<>();
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
        for (int num : map.keySet()) {
            pq.add(new int[]{num, map.get(num)});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}

