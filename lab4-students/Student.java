class Student extends BTree<Grade> implements Comparable<Student> {

         double gpa;
         int courses;
         String name;

         Student (String name) {
            this.name=name;
         }

         @Override
         public void in_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                
                in_order(grade.left);
                
                gpa+=grade.data.grade;
                courses++;
                  // test
                  // System.out.print(grade.data.course+":");
                  // System.out.print(grade.data.grade+"\n");
                
                // System.out.print(grade.data.grade+" ");
                
                in_order(grade.right);
                
            }
         }

         @Override
         public void pre_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                
                pre_order(grade.right);
                
                gpa+=grade.data.grade;
                courses++;
                  // test
                  // System.out.print(grade.data.course+":");
                  // System.out.print(grade.data.grade+"\n");
                
                System.out.print(grade.data.grade+" ");
                
                pre_order(grade.left);
                
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
            gpa=((int) (10*gpa))/10;
            return gpa;
         }

         double getCachedGPA() {
            return gpa;
         }

         @Override
         public int compareTo(Student to) {
            return (int) -(10*(getGPA()-to.getGPA())); // [k] reverse?? yep.
         }
    };