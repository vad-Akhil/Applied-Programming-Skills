class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i = 0; i<n; i++){
            if(group[i] == -1){
                group[i] = m++;
            }
        }

        HashMap<Integer,List<Integer>> map1 = new HashMap<>();
        HashMap<Integer,List<Integer>> map2 = new HashMap<>();
        for(int i = 0; i<n; i++){
            map1.put(i,new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            map2.put(i,new ArrayList<>());
        }

        for(int i = 0; i<n; i++){
            for(int j : beforeItems.get(i)){
                map1.get(j).add(i);

                if(group[j] != group[i]){
                    map2.get(group[j]).add(group[i]);
                }
            }
        }

        List<Integer> ll1 = toposort(map1);
        List<Integer> ll2 = toposort(map2);

        if(ll1.size() == 0 || ll2.size() == 0){
            return new int[]{};
        }

        HashMap<Integer,List<Integer>> buck = new HashMap<>();

        for(int el : ll1){
            int idx = group[el];
            buck.putIfAbsent(idx,new ArrayList<>());
            buck.get(idx).add(el);
        }

        int[] ans = new int[n];
        int i = 0;
        for(int el : ll2){
            if(buck.containsKey(el)){
                // ans[i++] = buck.get(el);
                for(int key : buck.get(el)){
                    ans[i++] = key;
                }
            }
        }
        return ans;
    }

    public List<Integer> toposort(HashMap<Integer,List<Integer>> map){
        int n = map.size();
        int[] indeg = new int[n];
        for(int i = 0; i<n;i++){
            for(int el : map.get(i)){
                indeg[el]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int el = q.poll();
            ans.add(el);
            for(int nbrs : map.get(el)){
                indeg[nbrs]--;
                if(indeg[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }
        return ans.size() == map.size() ? ans : new ArrayList();
    }
}