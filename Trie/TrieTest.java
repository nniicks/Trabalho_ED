package Trie;

public class TrieTest {

	public static void main(String[] args) {
        Trie trie = new Trie();
        
        trie.insert("palavra");
        System.out.println(trie.search("palavra")); // true
        System.out.println(trie.startsWith("pal")); // true
        System.out.println(trie.search("pala"));    // false
    }

}
