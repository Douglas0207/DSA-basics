public class findMiddle {
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
        Node head = LinkedListUtils.createNode(arr);
        int middle = findMiddle(head);
        System.out.println("middle Node is "+middle);
    }
    public static int findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null) // for odd linked list.... for even -> while (fast != null && fast.next != null)
        {
           slow = slow.next;
           fast = fast.next.next;
        }
     return slow.data;
    }
}
