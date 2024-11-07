package Trie;

public class TrieTest {

    public static void main(String[] args) {

        Trie[] trie = new Trie[1];

        // Inicializar todas as posições do vetor
        for (int i = 0; i < trie.length; i++) {
            trie[i] = new Trie();
        }

        for (int i = 0; i < trie.length; i++) {
            
            trie[i].insert("arquivo teste 1\n" + //
                                "\n" + //
                                "\n" + //
                                "");
            trie[i].insert("ola");
            
            System.out.println("Trie: ");
            //trie[i].printTrie();
            
            System.out.println();
            
            System.out.println(trie[i].startsWith("arquivo teste ")); // true
            //System.out.println(trie[i].startsWith("pal")); // true
            //System.out.println(trie[i].search("pala")); // false
            //trie[i].printTrie();
        }
    }

}