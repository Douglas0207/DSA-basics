public class deleteMiddleNode 
{
    public static void main(String[] args) 
    {
        int arr [] = {1,2,3,4,5,6,7};
        Node head = LinkedListUtils.createNode(arr);
        head = deleteMiddle(head);
        LinkedListUtils.printList(head);
    }
    public static Node deleteMiddle(Node head)
    {
        if (head == null || head.next == null) return null;
        
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next !=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
