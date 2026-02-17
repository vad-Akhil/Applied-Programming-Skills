class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] rez = new int[len];
        int[] stack = new int[len];
        int top = 0;
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (top > 0 && temp > temperatures[stack[top - 1]]) {
                int idx = stack[--top];
                rez[idx] = i - idx;
            }
            stack[top++] = i;
        }
        return rez;
    }
}
