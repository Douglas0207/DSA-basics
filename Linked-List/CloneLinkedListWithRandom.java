public class CloneLinkedListWithRandom 
{
    public static void main(String[] args) 
    {
        
    }
    public static Node cloneWithRandom(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            Node copyNode = new Node(temp.data,null);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp!=null)
        {
            Node copyNode = temp.next;
            if(temp.random!=null)
            {
                copyNode.random = temp.random.next;
            }
            else
            {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(-1,null);
        Node resultant = dummy;
        temp = head;
        while(temp!=null)
        {
            resultant.next = temp.next; // copy node head
            temp.next = temp.next.next;
            resultant = resultant.next;
            temp = temp.next;
        }
        return dummy.next;
    } 
}
