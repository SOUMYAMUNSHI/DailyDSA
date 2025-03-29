// package DSA.LinkedList;

class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void getList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getLength() {
        Node temp = head;
        int tempLength = 0;
        while (temp != null) {
            temp = temp.next;
            tempLength++;
        }
        return tempLength;
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }

        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) // This if will run very begining when the remove function is callrd or the
                         // initial length of listis null
            return null;

        Node temp = head; // initial value or If only one node is present
        Node pre = head; // initial value or If only one node is present

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) // ** This if will run after the previous length-- become zero
        {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) // This if will run if the length is zero from begining
            return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) // This if will run while the length become 0 after length--
        {
            tail = null;
        }
        return temp;
    }

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        System.out.println("Legnth: " + myLinkedList.getLength());
        myLinkedList.append(9);
        myLinkedList.prepend(18);
        myLinkedList.removeFirst();
        myLinkedList.getList();
        System.out.println("Legnth: " + myLinkedList.getLength());
        // myLinkedList.getHead();
        // myLinkedList.getTail();
        // System.out.println("The list before adding a element:");
        // myLinkedList.getList();
        // myLinkedList.append(9);
        // System.out.println("The list after adding a element:");
        // myLinkedList.getList();
        // myLinkedList.getHead();
        // myLinkedList.getTail();
        // System.out.println(myLinkedList.removeLast().value);
        // myLinkedList.getList();
        // System.out.println(myLinkedList.removeLast().value);
        // myLinkedList.getList();
        // System.out.println(myLinkedList.removeLast());
        // myLinkedList.getList();
        // myLinkedList.prepend(6);
        // myLinkedList.getList();
        // System.out.println(myLinkedList.getLength());
        // myLinkedList.prepend(9);
        // myLinkedList.prepend(10);
        // myLinkedList.prepend(11);
        // System.out.println("The list after prepending a element:");
        // myLinkedList.getList();
        // System.out.println(myLinkedList.getLength());
    }

}
