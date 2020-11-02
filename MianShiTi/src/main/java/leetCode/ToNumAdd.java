package leetCode;

/**
 * @author WXQ
 *
 * @author WXQ
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 *   如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *   您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *   示例：
 *
 *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 *
 *   Related Topics 链表 数学
 *
 * 最后返回的一定不能 有空节点，否则会多一个0，所以从第二个开始返回，每次给下一个节点赋值
 */
public class ToNumAdd {


    public static void main(String[] args) {
        ToNumAdd t = new ToNumAdd();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);
        System.out.println(t.solution(l1,l2));
    }
    public ListNode solution(ListNode l1, ListNode l2){
       ListNode result = new ListNode();
       ListNode current = result;
        if (l1 == null) {
           return l2;
       } else if (l2 == null) {
           return l1;
       } else if (l1 == null && l2 ==null) {
           return null;
       }

       int jinWei = 0;
       int curVal = 0;
        while (l1!= null||l2!=null){
            int sum = 0;
            if (l1!=null){
               int x = l1.val;
               l1 = l1.next;
               sum += x;
            }
            if (l2!=null){
                int y = l2.val;
                l2 = l2.next;
                sum += y;
            }
            if (jinWei==1){
                sum += 1;
                jinWei = 0;
            }
            jinWei = sum/10;
            curVal = sum%10;
            current.next = new ListNode(curVal);
            current = current.next;
       }
        if (jinWei == 1){
            current.next= new ListNode(1);
        }
       return result.next;
    }


    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int value){
            this.val = value;
        }
        public ListNode(){
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
