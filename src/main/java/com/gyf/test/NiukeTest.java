package com.gyf.test;

import com.alibaba.fastjson.JSON;
import com.gyf.niuke.*;
import com.gyf.offer.util.ListNode;
import com.gyf.offer.util.TreeNode;
import com.gyf.offer.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class NiukeTest {

    @Test
    public void testBM1() {
        ListNode list = Util.getListByLength(7);
        BM1 bm1 = new BM1();
        ListNode listNode = bm1.ReverseList(list);
        Util.logList(listNode);
    }

    @Test
    public void testBM2() {
        ListNode list = Util.getListByLength(5);
        BM2 bm2 = new BM2();
        ListNode listNode = bm2.reverseBetween(list, 2, 5);
        Util.logList(listNode);
    }

    @Test
    public void testBM3() {
        ListNode list = Util.getListByLength(7);
        BM3 bm3 = new BM3();
        ListNode listNode = bm3.reverseKGroup(list, 3);
        Util.logList(listNode);
    }

    @Test
    public void testBM17() {
        int[] nums = {-1,0,3,4,6,10,13,14};
        BM17 bm17 = new BM17();
        log.info("result={}",bm17.search(nums, 10));
    }

    @Test
    public void testBM18() {
        BM18 bm18 = new BM18();
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        log.info("result={}", bm18.Find(15, nums));
    }

    @Test
    public void testBM19() {
        BM19 bm19 = new BM19();
        int[] nums = {2,2,1,2,7,8,4};
        log.info("result={}", bm19.findPeakElement(nums));
    }

    @Test
    public void testBM20() {
        BM20  bm20 = new BM20();
        int[] nums = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        log.info("result={}",bm20.InversePairs(nums));
    }

    @Test
    public void testBM21() {
        BM21 bm21 = new BM21();
        int[] nums = {4,5,1,2,3};
        log.info("result={}", bm21.getMinNum(nums));
    }

    @Test
    public void testBM22() {
        BM22 bm22 = new BM22();
        String s1 = "2.0.1";
        String s2 = "2.0.0.0";
//        System.out.println(JSON.toJSONString(s1.split("\\.")));
        log.info("result={}", bm22.compare(s1,s2));
    }

    @Test
    public void testBM23() {
        BM23 bm23 = new BM23();
        TreeNode root = Util.getSimpleTree();
        log.info("result={}", JSON.toJSONString(bm23.preorderTraversal(root)));
    }

    @Test
    public void testBM24() {
        BM24 bm24 = new BM24();
        TreeNode tree = Util.getSimpleTree();
        log.info("result={}", JSON.toJSONString(bm24.inorderTraversal(tree)));
    }

    @Test
    public void testBM25() {
        BM25 bm25 = new BM25();
        TreeNode tree = Util.getSimpleTree();
        log.info("result={}", JSON.toJSONString(bm25.postorderTraversal(tree)));
    }

    @Test
    public void testBM26() {
//        BM26 bm26 = new BM26();
//        TreeNode tree = Util.getSimpleTree();
//        log.info("result={}", JSON.toJSONString(bm26.levelOrder(tree)));

    }

    @Test
    public void testBM27() {
        BM27 bm27 = new BM27();
        TreeNode tree = Util.getSimpleTree();
        log.info("result={}", JSON.toJSONString(bm27.Print(tree)));
    }

    @Test
    public void testBM28() {
        BM28 bm28 = new BM28();
        TreeNode tree = Util.getSimpleTree();
        log.info("result={}", bm28.maxDepth(tree));
    }

    @Test
    public void testBM29() {
        BM29 bm29 = new BM29();
        TreeNode treeNode = Util.getSimpleTree();
        log.info("result={}", bm29.hasPathSum(treeNode, 13));
    }

    
    @Test
    public void testBM30() {
//        BM30 bm30 = new BM30();
//        TreeNode simpleBalanceTree = Util.getSimpleBalanceTree();
//        TreeNode convert = bm30.Convert(simpleBalanceTree);
//        TreeNode tmp = convert;
//        while (tmp.right != null) {
//            log.info("tmp={}", tmp.val);
//            tmp = tmp.right;
//        }
//        log.info("--------------------------------------------");
//        while (tmp != null) {
//            log.info("reverse,tmp={}", tmp.val);
//            tmp = tmp.left;
    }

    @Test
    public void BM31() {
        BM31 bm31 = new BM31();
        TreeNode symmetryTree = Util.getSymmetryTree();
        log.info("result={}", bm31.isSymmetrical(symmetryTree));
    }

    @Test
    public void BM32() {
        BM32 bm32 = new BM32();
        TreeNode root1 = Util.getSimpleTree();
        TreeNode root2 = Util.getRightTree();
        TreeNode treeNode = bm32.mergeTrees(root1, root2);
        log.info("result={}",Util.logTreeFirstOrder(treeNode));
    }

    @Test
    public void BM33() {
        BM33 bm33 = new BM33();
        TreeNode tree = Util.getSimpleTree();
        TreeNode mirror = bm33.Mirror(tree);
        log.info("result={}", Util.logTreeFirstOrder(mirror));
    }

    @Test
    public void BM34() {
        BM34 bm34 = new BM34();
        TreeNode balanceTree = Util.getSimpleTree();
        log.info("result={}", bm34.isValidBST(balanceTree));
    }

    @Test
    public void BM36() {
        BM36 bm36 = new BM36();
        TreeNode notBalancetree = Util.getSimpleBalanceTree();
        log.info("result={}", bm36.IsBalanced_Solution(notBalancetree));
    }

    @Test
    public void BM37() {
        BM37 bm37 = new BM37();
        TreeNode balanceTree = Util.getSimpleBalanceTree();
        log.info("result={}", bm37.lowestCommonAncestor(balanceTree, 8, 6));
    }

    @Test
    public void BM38() {
        BM38 bm38 = new BM38();
        TreeNode balanceTree = Util.getSimpleBalanceTree();
        log.info("result={}", bm38.lowestCommonAncestor(balanceTree, 4, 8));
    }

    @Test
    public void BM39() {

    }

    @Test
    public void BM40() {
        BM40 bm40 = new BM40();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] vin = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = bm40.reConstructBinaryTree(pre, vin);
        log.info("result={}", Util.logTreeFirstOrder(treeNode));
    }


}
