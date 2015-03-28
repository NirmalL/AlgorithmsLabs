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

    static double randGrade() {
        Random rand = new Random();        
        double randomNum = rand.nextDouble()*(4.0) + 1.0;
        randomNum=((double) Math.round(10*randomNum))/10;
        return randomNum;
    }

    public static void main(String[] args) {

        BTree<Student> batch=new BTree<Student>() {
            @Override
            public void in_order(BTreeNode<Student> stu) {
                if (stu!=null) {
                    in_order(stu.left);
                    System.out.println(stu.data.getCachedGPA()+" ["+stu.data.regnum+"] "+stu.data.name);
                    stu.data.rev_in_order();
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
            
            batch.insert(stu);
        }

        batch.in_order();
    
    }
}