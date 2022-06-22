public class Node2 <E>{
    E element;
    Node2<E> next;
    Node2<E> prev;
    //int elementInt = (int) element;

    public Node2(E element, Node2 next, Node2 prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;

    }
    public Node2(E element){
        this(element, null, null);
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node2<E> getNext() {
        return next;
    }

    public void setNext(Node2<E> next) {
        this.next = next;
    }

    public Node2<E> getPrev() {
        return prev;
    }

    public void setPrev(Node2<E> prev) {
        this.prev = prev;
    }

}
