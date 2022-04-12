package com.github.krunalvora.snippets;

class LinkedLists {

    public static void main(String[] args) {

        DLinkedNode head = new DLinkedNode(2);
        DLinkedNode tail = new DLinkedNode(3);


        head.next = tail;

        DLinkedNode dummy = head;

        while (dummy != null) {
            System.out.println(dummy.val);
            dummy = dummy.next;
        }

        System.out.println(head.val);
        head.val += 5;
        System.out.println(head.val);
        
    }

}


class DLinkedNode {

    int val;
    DLinkedNode next;
    DLinkedNode previous;

    public DLinkedNode (int val) {
        this.val = val;
    }

    public DLinkedNode () {
    }

    // public void next(DLinkedNode next) {
    //     this.next = next;
    // }

    // public void previous(DLinkedNode previous) {
    //     this.previous = previous;
    // }

    // public void val(int val) {
    //     this.val = val;
    // }

}


