package Add_two_numbers;


  public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }




class Solution {

    public ListNode Revsersal(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next_node = null;
        while (curr!=null){
            next_node = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next_node;
        }
        return prev;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = Revsersal(l1);
        ListNode node2 = Revsersal(l2);
        int brrow = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (node1!=null||node2!=null || brrow!=0){
            int sum = brrow;
            if(node1!=null){
                sum += node1.val;
                node1 = node1.next;

            }

            if(node2!=null){
                sum += node2.val;
                node2 = node2.next;
            }
            tail.next = new ListNode(sum%10);
            tail = tail.next;

            brrow = sum/10;
        }

        return Revsersal(dummy.next);


    }
}