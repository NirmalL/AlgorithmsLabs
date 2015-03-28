class Grade implements Comparable<Grade> {
        double grade;
        String course;

        @Override
        public int compareTo(Grade to) {
            return (int) (10*(this.grade-to.grade));
        }

        Grade(String course, double grade) {
            this.course=course;
            this.grade=grade;
        }
    }