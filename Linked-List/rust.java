public class rust
{
    public static void main(String[] args) 
    {
        int arr [] = {9,9,9,9,9};
        Node head = LinkedListUtils.createNode(arr);
        LinkedListUtils.printList(head);
        head = reverse(head);
        LinkedListUtils.printList(head);
        head = add1ToHead(head);
        LinkedListUtils.printList(head);
    }
    public static Node reverse(Node head)
    {
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            Node nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }
    public static Node add1ToHead(Node head)
    {
        int carry = 1;
        Node temp = head;
        while(temp!=null)
        {
            temp.data = temp.data + carry;
            if(temp.data<10)
            {
                carry = 0;
                break;
            }
            else
            {
                temp.data = 0;
                carry =1;
            }
            temp = temp.next;
        }
        if(carry==1)
        {
            Node newNode = new Node(1,null);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
}