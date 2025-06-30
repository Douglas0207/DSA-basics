class ListNode {
    int data;
    ListNode next;
    ListNode bottom;

    ListNode(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}
public class FlattenLinkedList {

    public static ListNode buildLinkedList() 
    {
        ListNode head = new ListNode(5);
        head.bottom = new ListNode(7);
        head.bottom.bottom = new ListNode(8);
        head.bottom.bottom.bottom = new ListNode(30);

        head.next = new ListNode(10);
        head.next.bottom = new ListNode(20);

        head.next.next = new ListNode(19);
        head.next.next.bottom = new ListNode(22);
        head.next.next.bottom.bottom = new ListNode(50);

        head.next.next.next = new ListNode(28);
        head.next.next.next.bottom = new ListNode(35);
        head.next.next.next.bottom.bottom = new ListNode(40);
        head.next.next.next.bottom.bottom.bottom = new ListNode(45);

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = buildLinkedList();
        System.out.println("Initial vertical list from head:");
        printList(head); 
        head = flatten(head);
        printList(head);
    }
    public static ListNode flatten(ListNode head)
    {
        if(head==null || head.next== null)
        {
            return head;
        }
        ListNode mergedHead = flatten(head.next);
        return merge(head,mergedHead);
    }
    public static ListNode merge(ListNode t1, ListNode t2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(t1!=null && t2!=null)
        {
           if(t1.data<t2.data)
           {
             temp.bottom = t1;
             temp = t1;
             t1 = t1.bottom;
           }
           else
           {
            temp.bottom = t2;
             temp = t2;
             t2 = t2.bottom;
           }
           temp.next = null;
        }
        if(t1!=null)
        {
            temp.bottom = t1;
        }
        else
        {
            temp.bottom = t2;
        }
        return dummy.bottom;
    }
}
