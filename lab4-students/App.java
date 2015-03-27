import java.util.Random;
import java.io.*;
import java.util.*;

class App {

    static String[] regnos;
    // ={"E/11/010", "E/11/014", "E/11/019", "E/11/020", "E/11/024", "E/11/028", "E/11/029", "E/11/032", "E/11/037", "E/11/040", "E/11/044", "E/11/054", "E/11/059", "E/11/060", "E/11/064", "E/11/067", "E/11/080", "E/11/105", "E/11/106", "E/11/113", "E/11/132", "E/11/133", "E/11/137", "E/11/139", "E/11/143", "E/11/145", "E/11/148", "E/11/163", "E/11/171", "E/11/174", "E/11/183", "E/11/193", "E/11/201", "E/11/188", "E/11/204", "E/11/209", "E/11/217", "E/11/237", "E/11/258", "E/11/268", "E/11/269", "E/11/297", "E/11/305", "E/11/308", "E/11/311", "E/11/313", "E/11/315", "E/11/337", "E/11/343", "E/11/353", "E/11/368", "E/11/379", "E/11/381", "E/11/384", "E/11/395", "E/11/405", "E/11/419", "E/11/429", "E/11/431", "E/11/436", "E/11/438", "E/11/444", "E/11/452", "E/11/484", "E/11/485", "E/11/486", "E/11/487", "E/11/488"};

    static String[] names;
    // ={"T.M.S.U.B.Abeysinghe", "A.S.M.C.BAgalawatte", "W.G.N.M.Amarasinghe", "D.M.A.M.K.L.Andradi", "A.S.P.Athukorala", "B.A.N.Y.Balaarachchi", "K.Balakayan", "B.M.N.M.Balasooriya", "H.M.A.P.KBandara", "K.M.P.Bandara", "R.M.L.SBandara", "B.S.Bulathsinhala", "B.V.O.Chathuranga", "G.D.Chathuranga", "G.D.RDabarera", "W.T.Darshana", "J.P.T.Dhanushka", "U.W.T.DEhelepola", "C.N.Ekanayake", "M.S.D.Eranga", "P.AGregory", "D.L.Gunaratne", "K.A.R.L.A.Gunawardana", "S.D.T.Guruge", "M.G.Harischandra", "S.K.E.Harshani", "D.H.M.S.N.Herath", "T.D.Hirimuthugoda", "J.D.C.Jayalath", "D.N.Jayanath", "O.M.D.N.I.Jayathilaka", "K.E.G.A.P.Kadurugasyaya", "D.S.L.Karunasekara", "J.L.M.M.Jayawardena", "K.P.D.H.M.Karunatissa", "P.Keerthanan", "B.U.Kulathilaka", "Y.M.P.NLankathilaka", "M.M.D.B.Marasinghe", "N.B.U.SNanayakkara", "D.N.U.Naranpanawa", "K.N.M.Perera", "W.D.Y.NPiyasinghe", "W.M.S.Prasadima", "E.K.V.MPremaratne", "M.P.Prematilake", "R.M.P.Rajapaksha", "R.M.D.MRathnayake", "A.R.S.PRodrigo", "J.CSamarasinghe", "S.Selvaluxmiy", "A.S.D.Senevirathna", "V.Seralathan", "E.L.W.Shantha", "K.V.C.C.Somathilaka", "D.N.Tennakoon", "R.Velmakivan", "W.M.D.B.Weerakoon", "I.L.Weeraratne", "N.B.Weerasinghe", "W.M.T.G.I.S.Weerasooriya", "W.R.M.B.C.Wickramasinghe", "Y.A.D.S.S.Wijerathna", "K.W.H.N.T.Hettiarachchi", "W.T.S.Wehalla", "S.S.Manamendra", "M.B.K.Jayawardhana", "K.G.DE.A.Rajapakse"};

    static void getStudents() {
        FileReader fr;
        try {
            // if (args.length == 0) { // We're working with stdin
            //     wc(new InputStreamReader(System.in));
            // }
            // else { // We're working with a list of files
            // for (int i = 0; i < args.length; i++) {
            fr = new FileReader("e11com.txt");
            Scanner rec=new Scanner(fr);

            int num=Integer.parseInt(rec.next());
            regnos=new String[num];
            names=new String[num];

            for (int i=0; i<num; i++) {
                // System.out.println(rec.next());
                // wc(fr);
                regnos[i]=rec.next();
                names[i]=rec.next();
            }
            // }

            // 

            // }
        }
        catch (IOException e) {
            return;
        }
    }

    static double randGPA() {
        Random rand = new Random();        
        double randomNum = rand.nextDouble()*(4.0) + 1.0;
        randomNum=((int) (10*randomNum))/10;
        return randomNum;
    }

    public static void main(String[] args) {

        BTree<Student> batch=new BTree<Student>() {
            @Override
            public void in_order(BTreeNode<Student> stu) {
                if (stu!=null) {
                    in_order(stu.left);
                    System.out.println(stu.data.getCachedGPA()+" -- "+stu.data.name);
                    // System.out.println(stu.data.courses);
                    stu.data.rev_in_order();
                    System.out.println();
                    in_order(stu.right);
                }
            }
        };

        getStudents();
        
        for (int i=0; i<regnos.length; i++) {

            Student stu=new Student(names[i]);
            // for (int j=0; j<6; j++) {
                stu.insert(new Grade("CO321", randGPA()));
                stu.insert(new Grade("CO322", randGPA()));
                stu.insert(new Grade("CO323", randGPA()));
                stu.insert(new Grade("CO324", randGPA()));
                stu.insert(new Grade("CO325", randGPA()));
                stu.insert(new Grade("EE386", randGPA()));
            // }
            
            // test
            // System.out.println(stu.name+"::");
            // stu.in_order();
            
            batch.insert(stu);
        }

        batch.in_order();
    
    }
}