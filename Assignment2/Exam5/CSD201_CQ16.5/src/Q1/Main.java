public class Main {
    public static void main(String[] args) {
        // Create and initialize the ItemList
        ItemList itemList = new ItemList();
        itemList.insertItem(new Item("A", 4, 285));
        itemList.insertItem(new Item("B", 6, 610));
        itemList.insertItem(new Item("V", 11, 920));
        itemList.insertItem(new Item("N", 8, 330));
        itemList.insertItem(new Item("M", 15, 350));
        itemList.insertItem(new Item("E", 9, 260));

        // Create and initialize the OrderQueue
        OrderQueue orderQueue = new OrderQueue();
        orderQueue.enQueue("M", 7);
        orderQueue.enQueue("T", 4);
        orderQueue.enQueue("N", 5);
        orderQueue.enQueue("B", 9);
        orderQueue.enQueue("E", 2);
        orderQueue.enQueue("V", 3);

        // Display the results
        itemList.inorder();
        orderQueue.display();
    }
}