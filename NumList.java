
public class NumList {
    public Node next;
    Node head;

    private int size;
    static class Node extends NumList {
        public int head;
        public int data;
        public Node next;

        Node(int num)
        {data = num;
        next = null;}

        public int getnum(){
            return this.data;
        }

    }
    public Node get(){
        return this.head;
    }
    public void insert(int data)
    {
        Node new_node = new Node(data);

        if (this.head == null) {
            this.head = new_node;
        }
        else {
            Node tail = this.head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new_node;
        }
        this.size += 1;
    }


    public static void reverse(NumList numlist) {
        Node prev = null;
        Node current = numlist.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        numlist.head = prev;
    }


    public boolean equals(Object o){
        if (o == null)
            return false;
        if (!(o.getClass().equals(this.getClass())))
            return false;
        NumList l = (NumList)o;
        return this.head.equals(l.head) && this.head.next.equals(l.head.next);
    }

    // get number 1,2 and 3 build a string
    public static String toString(NumList l){
        Node head = l.head;
        StringBuilder finstring = new StringBuilder();
        while (head != null){
            finstring.append(head.data);
            head = head.next;
        }
        return finstring.toString();
    }

    public int getSize() {
        return this.size;
    }
}
