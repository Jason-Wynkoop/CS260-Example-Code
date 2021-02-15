package edu.ipfw.Huffman;

class Node{

    Node left;
    Node right;
    char data;

    public Node(){

    }
    public Node(char data){
        this.data = data;
    }
    public void setData(char data){
        this.data = data;
    }
    public char getData(){
        return this.data;
    }
    @Override
    public String toString(){
        if(this.data == Character.UNASSIGNED){
            return "No Value";
        }
        else
            return ""+this.data;
    }
}