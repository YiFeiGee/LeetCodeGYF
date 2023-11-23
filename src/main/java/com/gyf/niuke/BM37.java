package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BM37 {

    /**
     * 寻找二叉搜索树的最近公共祖先
     *      思路1：二叉搜索树的遍历是可以很简单模拟出来的，记录下到p和q的路径，然后遍历找最后一次相同节点就是最近的公共祖先
     */
    public int lowestCommonAncestor1 (TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        List<Integer> pPath =  getRootPath(root, p);
        List<Integer> qPath =  getRootPath(root, q);
        // 若有公共父节点，下标出现的一定是一样的，因为若出现公共父节点，从根到公共父节点的路径是一样的
        int res = -1;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (Objects.equals(pPath.get(i), qPath.get(i))) {
                // 最后一个相等的是最近的公共父节点
                res = pPath.get(i);
            }
        }
        return res;
    }

    private List<Integer> getRootPath(TreeNode root, int p) {
        List<Integer> list = new ArrayList<>();
        while (root.val != p) {
            list.add(root.val);
            if (root.val > p) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        list.add(p);
        return list;
    }


    /**
     * 思路2：解决树的问题优先考虑递归分解子问题，想一想是否能把问题拆解成子树的问题
     * -------------即对于根节点是这样的，子节点也是这样的；这时候就可以用递归遍历了
     * 对于本题来说:
     * 1、对于根节点，如果p,q都比root值大，那么公共父节点在右子树，如果p,q都比root值小，那么公共父节点在左子树
     *      但如果root值正好在p,q的中间，则root就是最近的公共祖先
     * 2、对于子树来说，情况也是如此，因此可以用递归来做
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        if ((root.val >= p && root.val <= q) || (root.val >= q && root.val <= p)) {
            return root.val;
        } else if (root.val >= p && root.val >= q) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
