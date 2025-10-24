public class Student {
    private String studentName;
    private int[] marks;
    private Student() {}

    // создание студента
    public Student(String studentName, int[] marks) {
        this();
        this.studentName = studentName;
        this.marks = marks;
    }

    // получение оценок студента
    public int[] getMarks() {
        return marks;
    }

    // копирование оценок студента
    public static int[] copyMarks(int[] original) {
        return original != null ? original.clone() : null;
    }

    // вывод текстового представления сущности Студент
    @Override
    public String toString() {
        String result = studentName + ": ";
        for(int i = 0; i < marks.length; i++) {
            if (i == marks.length - 1) {
                result = result + marks[i];
            }
            else {
                result = result + marks[i] + ", ";
            }
        }
        return result;
    }
}
