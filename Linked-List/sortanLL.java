public class sortanLL 
{
    public static void main(String[] args) 
    {
        int arr [] = {3,2,6,8,4,1,5,9,7};
        Node head = LinkedListUtils.createNode(arr);
        head = sortLL(head);
        LinkedListUtils.printList(head);
    }
    public static Node sortLL(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);
        return merge(leftHead,rightHead);
    }
    public static Node findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
           slow = slow.next;
           fast = fast.next.next;
        }
        return slow;
    }
    public static Node merge(Node t1,Node t2)
    {
        Node dummy = new Node(-1,null);
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
