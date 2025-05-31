/*
The structure of linked list is the following

class Node
{
int data;
Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        // add your code here
        //Brute Force - T.C: O(n)+O(n), S.C: O(n) [List]
        List<Integer> lst = new ArrayList<>();

        Node p = head;

        while(p!=null){
            lst.add(p.data);
            p=p.next;
        }

        Collections.sort(lst);

        Node t = head;

        int k=0;
        while(t!=null){
            t.data = lst.get(k++);
            t=t.next;
        }

        return head;
    }
}