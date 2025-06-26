public class DeleteAllKey 
{
    public static void main(String[] args) 
    {
        int arr [] = {10,4,10,10,6,10};
        Node head = LinkedListUtils.createNode(arr);
        LinkedListUtils.printNode(head);
        head = deleteKey(head,10);
        LinkedListUtils.printNode(head);
    }
    public static Node deleteKey(Node head ,int key)
    {
        Node temp = head;
        
        while (temp != null) 
        {
            if (temp.data == key) 
            {
                Node next = temp.next;

                    if (temp == head) 
                    {
                        head = next;

                        if (head != null) head.prev = null;
                    } 
                    else 
                    {
                        if (temp.prev != null) 
                        {
                            temp.prev.next = temp.next;
                        }
                        if (temp.next != null) 
                        {
                            temp.next.prev = temp.prev;
                        }
                    }
                    temp = next;
                } else 
                {
                    temp = temp.next;
                }
            }
        
            return head;
        }
        
}
