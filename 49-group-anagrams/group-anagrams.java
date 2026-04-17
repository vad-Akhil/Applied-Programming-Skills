class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key=func(strs[i]);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> res=new ArrayList<>();
        for(String item:map.keySet()){
            res.add(map.get(item));
        }
        return res;



    }
    public static String func(String item){
        int[] freq=new int[26];
        for(int i=0;i<item.length();i++){
            char ch=item.charAt(i);
            freq[ch-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(freq[i]+" ");
        }
        return sb.toString();
    }
}