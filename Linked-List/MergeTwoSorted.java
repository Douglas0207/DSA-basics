public class MergeTwoSorted 
{
    public static void main(String[] args) 
    {
        int arr1 [] = {2,4,8,10};
        Node head1 = LinkedListUtils.createNode(arr1);
        int arr2 [] = {1,3,3,6,11,14};
        Node head2 = LinkedListUtils.createNode(arr2);
        Node head3 = mergeTwoSortedLists(head1,head2);
        LinkedListUtils.printList(head3);
    }
    public static Node mergeTwoSortedLists(Node head1,Node head2)
    {
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(t1!=null && t2!=null)
        {
            if(t1.data<=t2.data)
            {
                temp.next = t1;
                t1 = t1.next;
                temp = temp.next;
            }
            else
            {
                temp.next = t2;
                t2 = t2.next;
                temp = temp.next;
            }
        }
        if(t1!=null)
        {
            temp.next = t1;
        }
        else
        {
            temp.next = t2;
        }
        return dummy.next;
    }
}
