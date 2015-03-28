import java.util.Random;
import java.io.*;
import java.util.*;

class App {

    static String[] regnos;

    static String[] names;

    static void getStudents() {
        FileReader fr;
        try {

            fr = new FileReader("e11com.txt");
            Scanner rec=new Scanner(fr);

            int num=Integer.parseInt(rec.next());
            regnos=new String[num];
            names=new String[num];

            for (int i=0; i<num; i++) {
                regnos[i]=rec.next();
                names[i]=rec.next();
            }

        }
        catch (IOException e) {
            return;
        }
    }

    final static double[] grades={4, 3.7, 3.3, 3, 2.7, 2.3, 2, 1.7, 1.3, 1, 0};

    static double randGrade() {
        Random rand = new Random();        
        int randomNum = rand.nextInt(grades.length);
        return grades[randomNum];
    }

    public static void main(String[] args) {

        BTree<Student> batch=new BTree<Student>() {
            @Override
            public void in_order(BTreeNode<Student> stu) {
                if (stu!=null) {
                    in_order(stu.left);
                    System.out.println(stu.data);
                    System.out.println();
                    in_order(stu.right);
                }
            }
        };

        getStudents();
        
        for (int i=0; i<regnos.length; i++) {

            Student stu=new Student(names[i], regnos[i]);
                stu.insert(new Grade("CO321", randGrade()));
                stu.insert(new Grade("CO322", randGrade()));
                stu.insert(new Grade("CO323", randGrade()));
                stu.insert(new Grade("CO324", randGrade()));
                stu.insert(new Grade("CO325", randGrade()));
                stu.insert(new Grade("EE386", randGrade()));
            stu.in_order();
            batch.insert(stu);
        }

        batch.in_order();
    
    }
}