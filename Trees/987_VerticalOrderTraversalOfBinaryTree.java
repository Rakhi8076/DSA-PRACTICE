/*
LeetCode 987 - Vertical Order Traversal of a Binary Tree

Topic: Trees, BFS, TreeMap, Sorting

Approach:
1. Perform BFS and store each node as:
   (horizontal distance, level, value).
2. Group nodes by horizontal distance using TreeMap.
3. Sort each column by:
   - level ascending
   - value ascending (if levels are equal)
4. Build the final answer column by column.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    static class Info {
        TreeNode node;
        int hd, level;

        Info(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0, 0));
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            Info curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;
            int level = curr.level;
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(new int[] { level, node.val });
            min = Math.min(min, hd);
            max = Math.max(max, hd);
            if (node.left != null) {
                q.add(new Info(node.left, hd - 1, level + 1));
            }

            if (node.right != null) {
                q.add(new Info(node.right, hd + 1, level + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int hd = min; hd <= max; hd++) {
            List<int[]> list = map.get(hd);
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            List<Integer> temp = new ArrayList<>();
            for (int[] arr : list) {
                temp.add(arr[1]);
            }
            result.add(temp);
        }
        return result;
    }
}
