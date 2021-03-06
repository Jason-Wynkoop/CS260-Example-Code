package edu.ipfw.Huffman;

/**
 * @author Okoye Chuka Daniel
 * Program Name: Hoffman Code Generator
 * Instructor: Per Kjeldass
 */
public class Huffman {

    public Node root;

    public Huffman(){
        this.root = new Node();
    }

    public void add(char data, String sequence){

        Node temp = this.root;
        int i = 0;
        for(i=0;i<sequence.length()-1;i++){

            if(sequence.charAt(i)=='0'){
                if(temp.left == null){
                    temp.left = new Node();
                    temp = temp.left;
                }
                else{
                    temp = (Node) temp.left;
                }
            }
            else
            if(sequence.charAt(i)=='1'){
                if(temp.right == null){
                    temp.right = new Node();
                    temp = temp.right;
                }
                else{
                    temp = (Node) temp.right;
                }
            }}

        if(sequence.charAt(i)=='0'){

            temp.left = new Node(data);
        }
        else{
            temp.right = new Node(data);

        }
    }

    public String getDecodedMessage(String encoding){

        String output = "";
        Node temp = this.root;
        for(int i = 0;i<encoding.length();i++){

            if(encoding.charAt(i) == '0'){
                temp = temp.left;

                if(temp.left == null && temp.right == null){
                    output+= temp.getData();
                    temp = this.root;
                }
            }
            else
            {
                temp = temp.right;
                if(temp.left == null && temp.right == null){
                    output+= temp.getData();
                    temp = this.root;
                }

            }
        }
        return output;
    }
    // Traversal of reconstructed huffman tree for debugging.
    public void traversal(Node node){

        if(node == null)
            return;
        System.out.println(node);
        traversal(node.left);
        traversal(node.right);

    }

}

