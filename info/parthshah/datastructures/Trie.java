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

    public String[] wordsStartingFrom(String s){
        return null;
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
}