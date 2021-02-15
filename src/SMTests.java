
class SMTest {

    public static void main(String peeps[]){
        SparseMatrix sm = new SparseMatrix();
        sm.put(5, 10, 50);
        sm.put(6, 10, 20);
        sm.put(2, 2, 100);
        System.out.println(sm);
        System.out.println(sm.get(500, 500));
        System.out.println(sm.get(6, 10));
        sm.put(5, 10, 1000);
        System.out.println("------\n"+sm);
        sm.put(6, 10, 0);
        System.out.println("------\n"+sm);
    }

}