public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        MyMap<Integer,String> map=new MyMap<>();
        map.put(1,"Hemant");
        map.put(2,"Janvi");
        map.put(3,"Gourav");
        map.put(4,"Akshya");
        map.put(5,"Ankit");
        map.put(6,"Ankita");
        map.put(7,"Jai");
        map.put(8,"Hema");
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
        System.out.println(map.get(7));
        map.put(2,"Janvi");
        System.out.println(map.get(2));
        }
}
