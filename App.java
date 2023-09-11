import java.util.Objects;

class GenericMap<K, V> {
    private Node<K, V> firstNode;

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            Node<K, V> current = firstNode;
            while (current.getNext() != null) {
                if (Objects.equals(current.getKey(), key)) {
                    current.setValue(value);
                    return;
                }
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    public V get(K key) {
        Node<K, V> current = firstNode;
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public void remover(K key) {
        Node<K, V> current = firstNode;
        while (current != null) {
            if (Objects.equals(current.getKey(), key)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    firstNode = current.getNext();
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, V> prev) {
            this.prev = prev;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}

