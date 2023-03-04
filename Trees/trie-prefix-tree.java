// LC 208 - Implement Trie (Prefix Tree)

import java.util.HashMap;
import java.util.Map;

public class LC208 {
    class Trie {
        class TrieNode {
            Boolean lastWord;
            Map<Character, TrieNode> childrenNodes;

            public TrieNode() {
                lastWord = false;
                childrenNodes  = new HashMap<>();
            }

        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = this.root;

            for(int i = 0; i < word.length(); i++) {
                if(!node.childrenNodes.containsKey(word.charAt(i))) {
                    node.childrenNodes.put(new Character(word.charAt(i)), new TrieNode());
                }

                node = node.childrenNodes.get(word.charAt(i));

                if(i == word.length() - 1) {
                    node.lastWord = true;
                }
            }
        }

        public boolean search(String word) {
            TrieNode node = this.root;

            for(int i = 0; i < word.length(); i++) {
                if(!node.childrenNodes.containsKey(word.charAt(i))) {
                    return false;
                }

                node = node.childrenNodes.get(word.charAt(i));

                if(i == word.length() - 1 && node.lastWord == false) {
                    return false;
                }
            }

            return true;

        }

        public boolean startsWith(String prefix) {
            TrieNode node = this.root;

            for(int i = 0; i < prefix.length(); i++) {
                if(!node.childrenNodes.containsKey(prefix.charAt(i))) {
                    return false;
                }

                node = node.childrenNodes.get(prefix.charAt(i));
            }

            return true;
        }
    }
}
