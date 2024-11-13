// Huffman Coding in Java
//Time complexity: O(nlogn) Space complexity :- O(N)
import java.util.PriorityQueue;
import java.util.Comparator;

// Purpose: This class represents a node in the Huffman tree.
// item stores the frequency of the character or combined frequency of two nodes.
// c stores the character associated with this node.
// left and right store references to the left and right child nodes in the Huffman tree.
// For comparing the nodes
class HuffmanNode {
    int item;    // Frequency of the character
    char c;      // Character
    HuffmanNode left;  // Left child in the Huffman tree
    HuffmanNode right; // Right child in the Huffman tree
}

// Purpose: This class implements the Comparator interface to define how nodes will be 
// compared in a priority queue.
// The nodes are compared based on the frequency (item). This comparator ensures that the
//  node with the smallest frequency has higher priority (i.e., it will be dequeued first).
class ImplementComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.item - y.item;
  }
}
//This class contains the main logic for constructing the Huffman tree and printing 
// the Huffman codes.
// Purpose: This recursive method traverses the Huffman tree and prints the Huffman codes 
// for each character.
// If the current node is a leaf node (i.e., it has no left or right children) and it
//  contains a character (i.e., Character.isLetter(root.c)), 
// it prints the character along with its corresponding Huffman code (the string s).
// For non-leaf nodes, the method recursively calls itself on the left and right children, 
// appending '0' for the left child and '1' for the right child to the current string s.
// Implementing the huffman algorithm
 class Huffman {
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {

      System.out.println(root.c + "   |  " + s);

      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void main(String[] args) {

    int n = 4;
    char[] charArray = { 'A', 'B', 'C', 'D' };
    int[] charfreq = { 5, 1, 6, 3 };

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = charArray[i];
      hn.item = charfreq[i];

      hn.left = null;
      hn.right = null;

      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {

      HuffmanNode x = q.peek();
      q.poll();

      HuffmanNode y = q.peek();
      q.poll();

      HuffmanNode f = new HuffmanNode();

      f.item = x.item + y.item;
      f.c = '-';
      f.left = x;
      f.right = y;
      root = f;

      q.add(f);
    }
    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    printCode(root, "");
  }
}