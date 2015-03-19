class Student implements Comparable<Student> {

    BTree<Double> gpas;
    String regno, name;

    Student (String regno, String name) {
        this.regno=regno;
        this.name=name;
        gpas=new BTree<Double>();
    }

    @Override
    public String toString() {
        return "";
    }

    public int compareTo (Student next) {
        int totalGPA=0;

        return 0;
    }

    void print() {
        System.out.print(regno + " : " + name + " : ");
        gpas.in_order();
    }

}