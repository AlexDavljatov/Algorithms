using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Algorithms
{

    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x)
        {
            val = x;
            next = null;
        }
    }
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x)
        {
            val = x;
            left = null;
            right = null;
        }
    }

    public class Solution
    {
        static void Main(String[] args)
        {
            TreeNode root = null;
            TreeNode l = new TreeNode(9);
            TreeNode r = new TreeNode(20);
            TreeNode rl = new TreeNode(15);
            TreeNode rlr = new TreeNode(7);
            //root.left = l;
            //root.right = r;
            r.left = rl;
            r.right = rlr;
            LinkedList<LinkedList<int>> result = new BinaryTreeLevelOrderTraversal().levelOrder(root);
            foreach (LinkedList<int> level in result)
            {
                foreach (int element in level)
                    Console.Write("{0} ", element);
                Console.WriteLine();
            }
            Console.ReadKey();
        }
    }
    public class RemoveNthNodeFromEndofList
    {
        void run()
        {
            ListNode head = new ListNode(1);
            ListNode copy = head;
            for (int i = 2; i < 1; i++)
            {
                copy.next = new ListNode(i);
                copy = copy.next;
            }
            ListNode list = removeNthFromEnd(ref head, 1);
            while (list != null)
            {
                Console.Write("{0} -> ", list.val);
                list = list.next;
            }
            Console.ReadKey();
        }
        public ListNode removeNthFromEnd(ref ListNode head, int n)
        {
            ListNode copy = head;
            int size = 0;
            while (copy.next != null)
            {
                ++size;
                copy = copy.next;
            }
            Console.WriteLine("{0} : {1}", size, copy.val);
            if (size == n - 1) return head.next;
            copy = head;
            for (int i = 0; i < size - n; i++)
                copy = copy.next;
            copy.next = copy.next.next;
            // Console.WriteLine("{0} : {1} : {2}", size, copy.val, copy.next.val);
            return head;
        }
    }
    public class InterleavingString
    {
        public bool isInterleave(String s1, String s2, String s3)
        {
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            char[] c1 = s1.ToCharArray();
            char[] c2 = s2.ToCharArray();
            char[] c3 = s2.ToCharArray();
            return false;
        }
    }
    public class BinaryTreeLevelOrderTraversal
    {
        public LinkedList<LinkedList<int>> levelOrder(TreeNode root)
        {
            LinkedList<LinkedList<int>> result = new LinkedList<LinkedList<int>>();
            LinkedList<TreeNode> graph = new LinkedList<TreeNode>();
            graph.AddLast(root);
            long levelCount = root == null ? 0 : 1;
            long nextLevelCount = 0;
            while ((graph.Count() > 0) && (levelCount > 0))
            {
                LinkedList<int> level = new LinkedList<int>();
                for (int i = 0; i < levelCount; i++)
                {
                    TreeNode cur = graph.First();
               //     Console.Write("{0} ", cur.val);
                    if (cur.left != null)
                    {
                        ++nextLevelCount;
                        graph.AddLast(cur.left);
                    }
                    if (cur.right != null)
                    {
                        ++nextLevelCount;
                        graph.AddLast(cur.right);
                    }
                    graph.RemoveFirst();
                    level.AddLast(cur.val);
                }
                result.AddLast(level);
                levelCount = nextLevelCount;
                nextLevelCount = 0;
            }
            return result;
        }
    }
    public class MaximalRectangle
    {
        public int maximalRectangle(char[][] matrix)
        {
            int[][] temp = new int[matrix.Length][];
            temp[0][0] = char[0][0] == '1';
            return 0;
        }
    }
}
