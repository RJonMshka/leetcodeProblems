// LC 211 - Add and search word data structure


import scala.Char;

import java.util.HashMap;
import java.util.Map;

public class LC211 {
    static class WordDictionary {

        class WordNode {
            Map<Character, WordNode> children;

            boolean isLeaf;

            public WordNode() {
                this.children = new HashMap<>();
                isLeaf = false;
            }
        }

        private WordNode root;

        public WordDictionary() {
            this.root = new WordNode();
        }

        public void addWord(String word) {
            WordNode node = this.root;

            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if(!node.children.containsKey(c)) {
                    node.children.put(new Character(c), new WordNode());
                }
                node = node.children.get(c);
            }

            node.isLeaf = true;
        }

        private boolean dfs(WordNode root, String word, int index) {
            WordNode node = root;
            for(int i = index; i < word.length(); i++) {
                if(word.charAt(i) == '.') {
                    // recursive approach
                    for(Character childCh: node.children.keySet()) {
                        boolean result = dfs(node.children.get(childCh), word, i + 1);
                        if(result) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    // iterative approach
                    if(!node.children.containsKey(word.charAt(i))) {
                        // does not contain the key in node
                        return false;
                    }
                    node = node.children.get(word.charAt(i));
                }
            }

            return node.isLeaf;
        }

        public boolean search(String word) {
            WordNode node = this.root;

            return dfs(node, word, 0);
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();

        dict.addWord("bad");

        dict.addWord("dad");

        dict.addWord("mad");

        dict.addWord("pad");

        boolean result1 = dict.search("bad");

        boolean result2 = dict.search(".ad");

        boolean result3 = dict.search("x..");

        boolean result4 = dict.search("...");
    }
}
