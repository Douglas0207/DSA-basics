import java.util.*;

public class OddEvenSLL 
{
    public static void main(String[] args) 
    {
        int arr[] = {1,3,4,2,5,6};
        Node head = LinkedListUtils.createNode(arr);
        LinkedListUtils.printList(head);
        head = sortOddEvenOptimized(head);
        LinkedListUtils.printList(head);
    }
    public static Node sortOddEven(Node head)
    {
      ArrayList<Integer> list = new ArrayList<>();
      Node temp = head;
      while(temp!=null && temp.next!=null)
      {
        list.add(temp.data);
        temp = temp.next.next;
      }
      if(temp!=null)
      {
        list.add(temp.data);
      }
      temp = head.next;
      while(temp!=null && temp.next!=null)
      {
        list.add(temp.data);
        temp = temp.next.next;
      }
      if(temp!=null)
      {
        list.add(temp.data);
      }
      temp = head;
      for(int i=0;i<list.size();i++)
      {
        temp.data = list.get(i);
        temp = temp.next;
      }
      return head;
    }
    public static Node sortOddEvenOptimized(Node head)
    {
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even!=null && even.next!=null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
