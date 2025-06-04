public class add2NumbersSLL
{
    public static void main(String[] args) 
    {
        int arr1[] = {4,5,9,9};
        Node head1 = LinkedListUtils.createNode(arr1);
        LinkedListUtils.printList(head1);
        int arr2[] = {3,5};
        Node head2 = LinkedListUtils.createNode(arr2);
        LinkedListUtils.printList(head2);
        Node sumNode = findSum(head1,head2);
        LinkedListUtils.printList(sumNode);
    }
    public static Node findSum(Node head1, Node head2)
    {
        int carry = 0;
        Node dummyHead = new Node(-1,null);
        Node dummy = dummyHead;
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1!=null || temp2!=null)
        {
           int sum = carry;
           if(temp1!=null)
           {
            sum = sum + temp1.data;
           }
           if(temp2!=null)
           {
            sum = sum+ temp2.data;
           }
           Node newNode = new Node(sum%10,null);
           carry = sum/10;
           dummy.next = newNode;
           dummy = newNode;
           if(temp1!=null)
           {
            temp1 = temp1.next;
           }
           if(temp2!=null)
           {
            temp2 = temp2.next;
           }
           if(carry>0)
           {
            dummy.next = new Node(carry,null);
           }
        }
        return dummyHead.next;
    }
}