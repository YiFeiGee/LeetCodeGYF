package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM39 {

    // 反序列化时的全局指针
    public int index = 0;

    /**
     * 序列化树
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        trySerialize(root, sb);
        return sb.toString();
    }

    private void trySerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#');
            return;
        }
        // 增加一个value分隔符
        sb.append(String.valueOf(root.val)).append("!");
        trySerialize(root.left, sb);
        trySerialize(root.right, sb);
    }

    /**
     * 反序列化树
     * 先序遍历的树，仍然利用先序遍历就能恢复
     * @param str
     * @return
     */
    public TreeNode Deserialize(String str) {
        if ("#".equals(str)) {
            return null;
        }
        return tryDeserialize(str);
    }

    private TreeNode tryDeserialize(String str) {
        if (index >= str.length()) {
            return null;
        }
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        // 还原数字
        int num = 0;
        while (index < str.length() && str.charAt(index) != '!') {
            num = num*10 + str.charAt(index) - '0';
            index++;
        }
        // 跳过‘！’
        index++;
        TreeNode root = new TreeNode(num);
        root.left = tryDeserialize(str);
        root.right = tryDeserialize(str);
        return root;
    }

}
