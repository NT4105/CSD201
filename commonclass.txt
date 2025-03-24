// // Node class for linked list and queue
// class Node {
// Item info;
// Node next;

// Node(Item x, Node p) {
// info = x;
// next = p;
// }

// Node(Item x) {
// this(x, null);
// }
// }

// // Node class for binary tree
// class ItemNode {
// Item info;
// ItemNode left, right;

// ItemNode(Item x) {
// info = x;
// left = right = null;
// }
// }

// // Linked List implementation
// class ItemList {
// Node head, tail;

// ItemList() {
// head = tail = null;
// }

// boolean isEmpty() {
// return head == null;
// }

// void clear() {
// head = tail = null;
// }

// // Add new item to end of list
// void addLast(String name, int quantity, int price) {
// Item item = new Item(name, quantity, price);
// Node node = new Node(item);
// if (isEmpty()) {
// head = tail = node;
// } else {
// tail.next = node;
// tail = node;
// }
// }

// // Add new item to start of list
// void addFirst(String name, int quantity, int price) {
// Item item = new Item(name, quantity, price);
// Node node = new Node(item);
// if (isEmpty()) {
// head = tail = node;
// } else {
// node.next = head;
// head = node;
// }
// }
// }

// // Queue implementation
// class OrderQueue {
// Node front, rear;

// OrderQueue() {
// front = rear = null;
// }

// boolean isEmpty() {
// return front == null;
// }

// void clear() {
// front = rear = null;
// }

// // Add new order to queue
// void enQueue(String name, int quantity) {
// Node node = new Node(new Item(name, quantity));
// if (isEmpty()) {
// front = rear = node;
// } else {
// rear.next = node;
// rear = node;
// }
// }

// // Remove and return first order
// Item deQueue() {
// if (isEmpty())
// return null;
// Item tmp = front.info;
// front = front.next;
// if (front == null) {
// rear = null;
// }
// return tmp;
// }
// }

// // Binary Search Tree implementation
// class BSTree {
// ItemNode root;

// BSTree() {
// root = null;
// }

// boolean isEmpty() {
// return root == null;
// }

// void clear() {
// root = null;
// }

// // Insert new node into BST
// ItemNode insert(ItemNode root, Item x) {
// if (root == null) {
// return new ItemNode(x);
// }
// if (x.getName().compareTo(root.info.getName()) < 0) {
// root.left = insert(root.left, x);
// } else if (x.getName().compareTo(root.info.getName()) > 0) {
// root.right = insert(root.right, x);
// }
// return root;
// }

// // Common traversal methods
// void preOrder(ItemNode p) {
// if (p == null)
// return;
// visit(p);
// preOrder(p.left);
// preOrder(p.right);
// }

// void inOrder(ItemNode p) {
// if (p == null)
// return;
// inOrder(p.left);
// visit(p);
// inOrder(p.right);
// }

// void postOrder(ItemNode p) {
// if (p == null)
// return;
// postOrder(p.left);
// postOrder(p.right);
// visit(p);
// }
// }

// // Common processing methods
// class OrderProcessing {
// // Update item stock after order
// void updateItemStock(ItemNode root, Item order) {
// if (root == null)
// return;

// int comp = order.getName().compareTo(root.info.getName());
// if (comp == 0) {
// if (root.info.getQuantity() >= order.getQuantity()) {
// root.info.setQuantity(root.info.getQuantity() - order.getQuantity());
// }
// } else if (comp < 0) {
// updateItemStock(root.left, order);
// } else {
// updateItemStock(root.right, order);
// }
// }

// // Process single order
// void processSingleOrder(Item order) {
// if (order != null) {
// updateItemStock(root, order);
// }
// }

// // Process all orders in queue
// void processAllOrders() {
// while (!orderQueue.isEmpty()) {
// Item order = orderQueue.deQueue();
// if (order != null) {
// updateItemStock(root, order);
// }
// }
// }
// }
