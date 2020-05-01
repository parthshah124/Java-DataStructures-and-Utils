package info.parthshah.datastructures;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String s){
        root.insert(s);
    }

    public boolean contains(String s){
        return root.contains(s);
    }

    public ArrayList<String> wordsStartingFrom(String prefix){
        if(prefix == null || prefix.isEmpty()) throw new IllegalArgumentException("Empty string is not a valid input!");
        ArrayList<String> result = new ArrayList<>();
        TrieNode prefixNode = root.findPrefixNode(prefix);
        dfs(prefixNode, result, prefix);
        return result;
    }

    private void dfs(TrieNode node, ArrayList<String> result, String prefix){
        if(node == null) return;
        if(node.isCompleteWord) result.add(prefix);
        HashSet<Character> children = node.children.keySet();
        if(children == null) return;
        else {
            for(Character child : children){
                dfs(node.children.get(child), result, prefix + child);
            }
        }
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean isCompleteWord;

    TrieNode(){
        children = new HashMap<>();
    }

    TrieNode(boolean isCompleteWord){
        children = new HashMap<>();
        this.isCompleteWord = isCompleteWord;
    }

    void insert(String s){
        if(!children.containsKey(s.charAt(0))) {
            children.put(s.charAt(0), new TrieNode());
        }
        if(s.length() == 1){
            children.get(s.charAt(0)).isCompleteWord = true;
        } else {
            children.get(s.charAt(0)).insert(s.substring(1));
        }
    }

    boolean contains(String s){
        if(s.length() == 1){
            if(children.containsKey(s.charAt(0)) && children.get(s.charAt(0)).isCompleteWord) return true;
            else return false;
        }
        if(!children.containsKey(s.charAt(0))) return false;
        else return children.get(s.charAt(0)).contains(s.substring(1));
    }

    TrieNode findPrefixNode(String prefix){
        if(prefix.length() == 1){
            if(children.containsKey(prefix.charAt(0))) return children.get(prefix.charAt(0));
            else return null;
        }
        if(!children.containsKey(prefix.charAt(0))) return null;
        else return children.get(prefix.charAt(0)).findPrefixNode(prefix.substring(1));
    }
}