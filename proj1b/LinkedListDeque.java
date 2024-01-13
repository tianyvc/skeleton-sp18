public class LinkedListDeque <T> {

    public class Node
    {
        private T item;
        private Node prev;
        private Node next;

        public Node (T t, Node pprev, Node nnext)
        {
            item = t;
            prev = pprev;
            next = nnext;
        }
        public Node (Node pprev, Node nnext)
        {
            prev = pprev;
            next = nnext;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque()
    {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public int size()
    {
        return size;
    }

    public void addFirst(T item)
    {
        Node newList = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newList;
        sentinel.next = newList;
        size++;
    }

    public void addLast(T item)
    {
        Node newList = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newList;
        sentinel.prev = newList;
        size++;
    }

    public T removeFirst()
    {
        if(size == 0)
        {
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    public T removeLast()
    {
        if(size == 0)
        {
            return null;
        }
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return ret;
    }
    public T get(int n)
    {
        if(n >= size)
        {
            return null;
        }
        Node ptr = sentinel;
        for(int i = 0; i <= n; i ++)
        {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getRecursiveHelp(Node start, int index)
    {
        if(index == 0)
        {
            return start.item;
        }
        else
        {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public T getRecursive(int index)
    {
        if(index >= size)
        {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    public void printDeque()
    {
        Node ptr = sentinel.next;
        while(ptr != sentinel)
        {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }
}