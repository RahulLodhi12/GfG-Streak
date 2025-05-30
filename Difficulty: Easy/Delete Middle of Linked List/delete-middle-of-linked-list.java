/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head==null || head.next==null) return null;

        Node f = head;
        Node s = head;

        Node prev=null;

        while(f!=null && f.next!=null){
            prev=s;
            s=s.next;
            f=f.next.next;
        }

        prev.next = s.next;
        s.next=null;

        return head;
    }
}