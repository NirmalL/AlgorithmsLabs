class Student extends BTree<Grade> implements Comparable<Student> {

         double gpa;
         int courses;

         @Override
         public void in_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                in_order(grade.left);
                gpa+=grade.data.grade;
                courses++;
                in_order(grade.right);
               // test
               // System.out.print(grade.data.course+":");
               // System.out.print(grade.data.grade);
            }
         }

         @Override
         public void in_order() {
            in_order(rootNode);
         }

         double getGPA() {
            gpa=0.0;
            courses=0;
            in_order();
            gpa/=courses;
            return gpa;
         }

         @Override
         public int compareTo(Student to) {
            return (int) (10*(getGPA()-to.getGPA()));
         }
    };