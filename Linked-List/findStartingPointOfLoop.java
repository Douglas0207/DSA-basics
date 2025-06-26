
public class findStartingPointOfLoop 
{
    public static void main(String[] args)
    {
        int arr [] = {1,2,3,4,5,6,7,8,9,10};
        Node head = LinkedListUtils.createNode(arr);
        head = createLoopAt4(head);
        head = findStartingPoint(head);
    }
    public static Node createLoopAt4(Node head)
    {
        Node loopNode = null;
        Node temp = head;
        while(temp.next!=null)
        {
            if(temp.data==4)
            {
              loopNode = temp;
            }
            temp = temp.next;
        }
        if(loopNode != null)
        {
           temp.next = loopNode;
        }
        return head;
    }
    public static Node findStartingPoint(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                Node start = head;
                while(start!=slow)
                {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }
}
