import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    String nama;
    LinkedList<Node> following;
    LinkedList<Node> followers;
    
    public Node(String nama){
        this.nama = nama;
        this.following = new LinkedList<>();
        this.followers = new LinkedList<>();
    }
    
    void addFollowing(Node followingNode){
        following.addLast(followingNode);
    }
    
    void addFollowers(Node followersNode){
        followers.addLast(followersNode);
    }

    public int size() {
        return 0;
    }

    public char[] get(int i) {
        return null;
    }
}

class Graph {
      public LinkedList<Node> user;
    
    public Graph (){
        this.user = new LinkedList<>();
    }
    
    void addName(String nama){
        for (int i = 0; i < user.size(); i++){
            if (!user.get(i).nama.equals(nama)){
                Node node = new Node(nama);
                user.addLast(node);
            }else{
                user.addLast(null);
            }
        }
    }
    
    void addConnect(String nama1, String nama2){
        Node node1 = findUser(nama1);
        Node node2 = findUser(nama2);
        
        if (node1 != null && node2 != null && node1 != node2){
            node1.addFollowing(node2);
            node2.addFollowers(node1);
        }
    }

    Node findUser(String nama){
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).nama.equals(nama)){
                return user.get(i);
            }
        }
        return null;
    }
    
    void printAll(){
        int lastI = user.size()-1;
        
        for (int i = 0; i < user.size(); i++){
            Node users = user.get(i);
            System.out.println(users.nama + "'s followings :");
            for (Node following: user){
                if (users.following.contains(following)){
                    System.out.println(" " + following.nama);
                }
            }
            
            System.out.println(users.nama + "'s followers :");
            for (Node followers: user){
                if (users.followers.contains(followers)){
                    System.out.println(" " + followers.nama);
                }
            }
            
            if (i != lastI){
                System.out.println();
            }
        }
        
    }
    
    void print(String nama){
        Node users = findUser(nama);

        System.out.println(users.nama + "'s followings :");
        for (Node following: user){
            if (users.following.contains(following)){
                System.out.println(" " + following.nama);
            }
        }

        System.out.println(users.nama + "'s followers :");
        for (Node follower: user){
            if (users.followers.contains(follower)){
                System.out.println(" " + follower.nama);
            }
        }
    }
}

public class Filgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Graph g = new Graph();
        
        int n = sc.nextInt();sc.nextLine();
        
        for (int i = 0; i < n; i++){
            g.addName(sc.nextLine());
        }
        
        int m = sc.nextInt();sc.nextLine();
        
        String command = ""; 
        
        String[] splitted = new String[3]; 
        
        for (int i = 0; i < m; i++){
            command = sc.nextLine();
            splitted = command.split(" ");
            
            if (splitted[1].equals("follow")){
                g.addConnect(splitted[0], splitted[2]);
            }else if (splitted[1].equals("connections")){
                if (splitted[0].equals("all")){
                    g.printAll();
                }else{
                    g.print(splitted[0]);
                }
                
            }
        }
    }
}
