public class add1Recursion 
{
    public static void main(String[] args)
    {
        int arr [] = {9,9,9};
        Node head = LinkedListUtils.createNode(arr);
        head = recursiveSolution(head);
        LinkedListUtils.printList(head);
    }
    public static Node recursiveSolution(Node head)
    {
        int carry = helper(head);
        if(carry==1)
        {
           Node newNode = new Node(1,null);
           newNode.next = head;
           return newNode;
        }
        return head;
    }
    public static int helper(Node temp)
    {
        if(temp==null)
        {
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if(temp.data<10)
        {
            return 0;
        }
        temp.data = 0;
        return 1;
    }
}
