package edu.slcc.asdv;

public class Generics<GenericsList> {

    private java.util.ArrayList<GenericsList> list = new java.util.ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public GenericsList peek() {
        return list.get(getSize() - 1);
    }

    public void push(GenericsList o) {
        list.add(o);
    }

    public GenericsList pop() {
        GenericsList GenericList = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return GenericList;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    public static void main(String[] args) {
        Generics<Integer> GSI = new Generics();
        Generics<String> GSS = new Generics();

        GSI.push(10);
        GSI.push(20);

        GSS.push("John");
        GSS.push("Merry");

        System.out.println(GSI);
        System.out.println(GSI.peek());
        System.out.println(GSI.pop());
        System.out.println();
    }
}
