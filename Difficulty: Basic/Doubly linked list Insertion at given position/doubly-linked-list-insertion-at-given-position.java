/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node temp = new Node(x);
        
        int cnt=0;
        
        Node ptr=head;
        
        while(ptr!=null && cnt<p){
            ptr=ptr.next;
            cnt++;
        }
        
        temp.next = ptr.next;
        // ptr.next.prev = temp;
        ptr.next = temp;
        temp.prev = ptr;
        
        return head;
    }
}