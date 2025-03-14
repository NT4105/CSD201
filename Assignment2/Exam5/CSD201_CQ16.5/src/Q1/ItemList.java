package Q1;

public class ItemList {
    private ItemNode root;

    public ItemList() {
        root = null;
    }

    // f1: Insert an item into the BST using name as key
    public void insertItem(Item item) {
        root = insertRec(root, item);
    }

    private ItemNode insertRec(ItemNode node, Item item) {
        if (node == null) {
            return new ItemNode(item);
        }

        // Compare names to determine insertion position
        int compareResult = item.getName().compareTo(node.getItem().getName());

        if (compareResult < 0) {
            node.setLeft(insertRec(node.getLeft(), item));
        } else if (compareResult > 0) {
            node.setRight(insertRec(node.getRight(), item));
        }

        return node;
    }

    // Inorder traversal to display items
    public void inorder() {
        System.out.print("Available items: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(ItemNode node) {
        if (node != null) {
            inorderRec(node.getLeft());
            System.out.print(node.getItem() + " ");
            inorderRec(node.getRight());
        }
    }
}