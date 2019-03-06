package ru.f3n3gz.Tree;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> rootNode;
    private int height;

    public TreeImpl() {
        this.height = Integer.MAX_VALUE;
    }

    public TreeImpl(int height) {

        this.height = height;
    }

    private static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        int currentHeight = 0;
        if (isEmpty()) {
            rootNode = newNode;
            return;
        }

        Node<E> current = rootNode;
        Node<E> parent = null;
        while (current != null) {
            parent = current;
//            if (current.getValue().equals(element)) {
//                return;
//            }

            if (current.shouldLeftChild(element)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (++currentHeight > this.height) {
                return;
            }

        }
        if (parent.shouldLeftChild(element)) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }
    }

    @Override
    public boolean remove(E element) {
        Node<E> current = rootNode;
        Node<E> parent = null;

        while (current != null) {
            if (current.getValue().equals(element)) {
                break;
            }

            parent = current;
            if (current.shouldLeftChild(element)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        if (current == null) {
            return false;
        }

        if (isLeaf(current)) {
            if (current == rootNode) {
                rootNode = null;
            } else if (parent.getLeftChild().equals(current)) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (hasOnlyOneChild(current)) {
            Node<E> childNode = current.getLeftChild() != null
                    ? current.getLeftChild()
                    : current.getRightChild();

            if (childNode == rootNode) {
                rootNode = childNode;
            } else if (parent.getLeftChild().equals(current)) {
                parent.setLeftChild(childNode);
            } else {
                parent.setRightChild(childNode);
            }
        } else {
            Node<E> successor = getSuccessor(current);
            if (current == rootNode) {
                rootNode = successor;
            } else if (parent.getRightChild().equals(current)) {
                parent.setRightChild(successor);
            } else {
                parent.setLeftChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    /*
    получаем преемника
    метод вызывается только если есть 2 потомка
     */
    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private boolean hasOnlyOneChild(Node<E> node) {
        return node.getLeftChild() == null ^ node.getRightChild() == null;
    }

    private boolean isLeaf(Node<E> node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    @Override
    public boolean find(E element) {
        return false;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(rootNode);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isEmpty() {
        return rootNode == null;
    }

    @Override
    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode) {
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode " + traverseMode);
        }
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.println(node);
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.println(node);
    }

    public boolean isBalanced() {
        return isBalanced(rootNode);
    }
}
