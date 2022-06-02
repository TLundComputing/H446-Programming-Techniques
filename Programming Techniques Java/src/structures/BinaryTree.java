package structures;

import java.util.ArrayList;

public class BinaryTree {

    private class Node<T> {
        private T data;
        private int leftPointer, rightPointer;

        public Node(T theData){
            data = theData;
            leftPointer = -1;
            rightPointer = -1;
        }

        public T getData() {
            return data;
        }

        public int getLeftPointer(){
            return leftPointer;
        }

        public int getRightPointer(){
            return rightPointer;
        }

        public void setLeftPointer(int newValue){
            leftPointer = newValue;
        }

        public void setRightPointer(int rightPointer) {
            this.rightPointer = rightPointer;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    private final ArrayList<Node> tree;
    private int pointer;

    public BinaryTree(){
        tree = new ArrayList<>();
        pointer = -1;
    }

    public void addItem(Object item){
        tree.add(new Node<>(item));
        pointer += 1;
        findPlace(0, tree.get(pointer));
    }

    private void findPlace(int nodeIndex, Node item){
        Node<Object> currentNode = tree.get(nodeIndex);
        if((Integer) currentNode.getData() >= (Integer) item.getData()){
            if(currentNode.getLeftPointer() != -1){
                findPlace(currentNode.getLeftPointer(), item);
            } else {
                currentNode.setLeftPointer(pointer);
            }
        } else if((Integer) currentNode.getData() < (Integer) item.getData()) {
            if(currentNode.getRightPointer() != -1){
                findPlace(currentNode.getRightPointer(), item);
            } else {
                currentNode.setRightPointer(pointer);
            }
        }
    }

}
