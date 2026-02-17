import java.util.*;
class Solution {
    class NodeInfo {
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));
        while (!queue.isEmpty()) {
            NodeInfo cur = queue.poll();
            TreeNode node = cur.node;
            int row = cur.row;
            int col = cur.col;
            map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);
            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }
        return result;
    }
}
