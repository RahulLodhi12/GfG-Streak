//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Structure for the linked list node
struct Node {
    int data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

// Function to print nodes in a given circular linked list
void printList(struct Node *head) {
    if (head != NULL) {
        struct Node *temp = head;
        do {
            cout << temp->data << " ";
            temp = temp->next;
        } while (temp != head);
    } else {
        cout << "empty" << endl;
    }
    cout << endl;
}


// } Driver Code Ends
class Solution {
  public:
    // Function to reverse a circular linked list
    Node* reverse(Node* head) {
        // code here
        Node* Prev = NULL;
        Node* Curr = head;
        Node* Next = Curr->next;
        
        while(Next != head){
            Curr->next = Prev;
            Prev = Curr;
            Curr = Next;
            Next = Next->next;
        }
        // at this point next = head & Curr = last node
        Next->next = Curr;
        Curr->next = Prev;
        
        return Curr;
    }

    // Function to delete a node from the circular linked list
    Node* deleteNode(Node* head, int key) {
        // code here
        Node* p=head;
        Node* t=head->next;
        if(head==NULL or (head->next==head and head->data==key)) return NULL;
        
        if(head->data==key){
            while(p->next!=head){
                p=p->next;
            }
            p->next = t;
            delete head;
            
            return t; //new head
        }
        else{
            while(t->data!=key and t!=head){
                p=t; //prev
                t=t->next;
            }
            if(t->data==key){
                p->next=t->next;
                delete t;
            }
        }
        
        return head;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;

        // Reading input into a vector
        while (ss >> number) {
            arr.push_back(number);
        }

        int key;
        cin >> key;
        cin.ignore();

        // Creating the circular linked list
        struct Node *head = new Node(arr[0]);
        struct Node *tail = head;
        for (int i = 1; i < arr.size(); ++i) {
            tail->next = new Node(arr[i]);
            tail = tail->next;
        }
        tail->next = head; // Make the list circular

        Solution ob;

        // Delete the node with the given key
        head = ob.deleteNode(head, key);

        // Reverse the circular linked list
        head = ob.reverse(head);

        // Print the modified list
        printList(head);
    }
    return 0;
}

// } Driver Code Ends