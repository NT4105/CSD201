public class OrderNode {
    private String itemName;
    private int quantity;
    private OrderNode next;

    public OrderNode(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.next = null;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderNode getNext() {
        return next;
    }

    public void setNext(OrderNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "(" + itemName + "," + quantity + ")";
    }
}