class Student extends BTree<Grade> implements Comparable<Student> {

         double gpa;
         int courses;
         String name, regnum, str="";

         Student (String name, String regnum) {
            this.name=name;
            this.regnum=regnum;
         }

         @Override
         public void in_order(BTreeNode<Grade> grade) {
            if (grade!=null) {
                
                in_order(grade.left);
                
                gpa+=grade.data.grade;
                courses++;
                str+=(grade.data.grade+" ");

                in_order(grade.right);
                
            }
         }

         @Override
         public int compareTo(Student to) {
            return (int) -(100*(gpa-to.gpa));
         }

         @Override
         public String toString() {
            in_order();
            return ((double) Math.round(100*gpa/courses))/100+" ["+regnum+"] "+name+"\n"+str;
         }
    };