import java.util.*;

public class findLengthOfLoop
{
    public static void main(String[] args) 
    {
        int arr [] = {1,2,3,4,5,6,7,8,9,10};
        Node head = LinkedListUtils.createNode(arr);
        head = createLoopAt4(head);
        int length1 = findLength(head);
        System.out.println("The length of the Loop is "+length1);
        int length2 = findLengthOptimized(head);
        System.out.println("The length of the loop is "+length2);
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
    public static int findLength(Node head )
    {
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 1;

        while(temp!=null)
        {
            if(map.containsKey(temp)==true)
            {
                int value = map.get(temp);
                return timer - value ;
            }
            map.put(temp,timer);
            timer++;
            temp = temp.next;
        }
        return 0;
    }
     public static int findLengthOptimized(Node head)
     {
        Node slow= head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                return findLengthOpFunc(slow,fast);
            }
        }
        return 0;
     }
     public static int findLengthOpFunc(Node slow , Node fast)
     {
        int count = 1;
        fast = fast.next;
        while(slow!=fast)
        {
            fast=fast.next;
            count++;
        }
        return count;
     }
}