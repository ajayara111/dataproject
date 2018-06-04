package hello;

public class ReverseAdd {
    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode resultNode = null;
            int carry = 0;
            if ((l1.next != null)  && (l2.next != null)){
                int addition = (l1.next.val + l2.next.val +carry ) % 10;
                carry = ((l1.next.val + l2.next.val + carry)) /10;
                ListNode ln = new ListNode(addition);
                if (resultNode == null)
                    resultNode = ln;
                else {
                    resultNode.next = ln;
                    resultNode = resultNode.next;
                }

                l1 = l1.next;
                l2 = l2.next;

            }
            else  if(l1.next != null && l2.next == null){
                int addition = (l1.next.val +  +carry ) % 10;
                carry = ((l1.next.val  + carry)) /10;
                ListNode ln = new ListNode(addition);
                if (resultNode == null)
                    resultNode = ln;
                else {
                    resultNode.next = ln;
                    resultNode = resultNode.next;
                }

                l1 = l1.next;


            }
            else  if(l1.next == null && l2.next != null){
                int addition = (l2.next.val +  +carry ) % 10;
                carry = ((l2.next.val  + carry)) /10;
                ListNode ln = new ListNode(addition);
                if (resultNode == null)
                    resultNode = ln;
                else {
                    resultNode.next = ln;
                    resultNode = resultNode.next;
                }

                l1 = l2.next;


            }
            return resultNode;


        }
    }
}
