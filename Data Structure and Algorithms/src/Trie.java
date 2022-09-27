import java.util.Hashtable;

class TrieNode {
    Hashtable<String, TrieNode> children;
}

public class Trie {
    private TrieNode rootNode = new TrieNode();

    public void insert(String word) {
        TrieNode currentNode = rootNode;
        String[] splitWord = word.split("");
        for (String strI : splitWord) {
            if (!currentNode.children.containsKey(strI)) {
                currentNode.children.put(strI, new TrieNode());
            }
            currentNode = currentNode.children.get(strI);
        }
        currentNode.children.put("*", null);
    }

    public boolean search(String word) {
        TrieNode currentNode = rootNode;
        String[] splitWord = word.split("");
        for (String strI : splitWord) {
            if (!currentNode.children.containsKey(strI)) {
                return false;
            } else {
                currentNode = currentNode.children.get(strI);
            }
        }
        return currentNode.children.containsKey("*");
    }

    public static void main(String[] args) {
    }
}
