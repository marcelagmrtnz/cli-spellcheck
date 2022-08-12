class Node {
    public char value;
    public List<Node> children;

    public Node (char value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
