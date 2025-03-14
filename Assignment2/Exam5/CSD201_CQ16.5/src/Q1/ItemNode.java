package Q1;

public class ItemNode {
    private Item item;
    private ItemNode left, right;

    public ItemNode(Item item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public Item getItem() {
        return item;
    }

    public ItemNode getLeft() {
        return left;
    }

    public void setLeft(ItemNode left) {
        this.left = left;
    }

    public ItemNode getRight() {
        return right;
    }

    public void setRight(ItemNode right) {
        this.right = right;
    }
}