package deque;

public class LinkedListDeque<T>{

        private IntNode sentinel;
        private int size;
        public class IntNode {
            public IntNode prev;
            public T item;
            public IntNode next;
        }

        public LinkedListDeque(){
            sentinel = new IntNode();
            sentinel.item = null;
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
        }

        public void addFirst(T item){
            IntNode tempNode = new IntNode();
            tempNode.item = item;

            tempNode.next = sentinel.next;
            sentinel.next.prev = tempNode;
            sentinel.next = tempNode;
            tempNode.prev = sentinel;

            size += 1;
        }

        public void addLast(T item){
            IntNode tempNode = new IntNode();
            tempNode.item = item;

            tempNode.prev = sentinel.prev;
            sentinel.prev.next = tempNode;
            tempNode.next = sentinel;
            sentinel.prev = tempNode;

            size += 1;
        }

        public boolean isEmpty(){
            if(size == 0){
                return true;
            }else{
                return false;
            }
        }

        public int size(){
            return this.size;
        }

        public void printDeque(){
            IntNode temp = sentinel;
            while(temp.next != sentinel){
                temp = temp.next;
                System.out.printf("%s ", temp.item.toString());
            }
            System.out.println();
        }

        public T removeFirst(){
            T tempItem;
            if(size == 0){
                return null;
            }else if (size ==  1){
                tempItem = sentinel.next.item;
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
                size -= 1;
                return tempItem;
            } else {
                tempItem = sentinel.next.item;
                sentinel.next.next.prev = sentinel;
                sentinel.next = sentinel.next.next;
                size -= 1;
                return tempItem;
            }
        }

        public T removeLast(){
            T tempItem;
            if(sentinel.prev == sentinel){
                return null;
            } else {
                tempItem = sentinel.prev.item;
                sentinel.prev.prev.next = sentinel;
                sentinel.prev = sentinel.prev.prev;
                size -= 1;
                return tempItem;
            }
        }

        public T get(int index){
            IntNode temp = sentinel;
            if(size == 0 || index >size)
                return null;
            else{
                for(int i = 1; i <= index; i++){
                    temp = temp.next;
                }
                return temp.item;
            }
        }

        public T getRecursive(int index){
            if(index > size || size == 0) {
                return null;
            }else{
                return recursiveHelper(index, this.sentinel);
            }
        }
        private T recursiveHelper(int index, IntNode node){
            if(index == 0){
                return node.item;
            }else{
                return recursiveHelper(index -1, node.next);
            }
        }

        /*public Iterator<T> iterator(){

        }

        public boolean equals(Object o){

        }*/

}
