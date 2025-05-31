/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node merge(Node left, Node right){
        //using dummy node
        Node dummy = new Node(-1);
        Node p=dummy;
        
        Node l = left;
        Node r = right;
        
        while(l!=null && r!=null){
            if(r.data<=l.data){
                p.next=r;
                p=p.next;
                r=r.next;
            }
            else{
                p.next=l;
                p=p.next;
                l=l.next;
            }
        }
        
        while(l!=null){
            p.next=l;
            p=p.next;
            l=l.next;
        }
        
        while(r!=null){
            p.next=r;
            p=p.next;
            r=r.next;
        }
        
        return dummy.next;
    }
    static Node divide(Node head){
        //base case
        if(head==null || head.next==null) return head;
        
        
        //find mid
        Node s=head;
        Node f=head.next;
        
        
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        
        Node left = head;
        Node right = s.next;
        s.next=null;
        
        left = divide(left);
        right = divide(right);
        
        return merge(left,right);
    }
    static Node segregate(Node head) {
        // code here
        if(head==null || head.next==null) return head;
        
        return divide(head);
    }
}