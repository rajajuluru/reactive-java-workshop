package io.javabrains.reactiveworkshop;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamsProgrammingQuestions {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "sonu", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "ram", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        //print all students in between 50 to hundered
        List<Student> rankbetween50and100 = studentList.stream()
                .filter((student) -> student.getRank() >= 50
                        && student.getRank() <= 100).collect(Collectors.toList());
        System.out.println("print all students in between 50 to hundered");
        System.out.println(rankbetween50and100);

        //group by city and sort the list via name
        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getCity));
        System.out.println("before sorting");
        System.out.println(collect);
        System.out.println(collect.get("Karnataka"));
        Map<String, List<Student>> collect2 = new LinkedHashMap<>();
        collect.entrySet().stream().forEach((s) -> {
            List<Student> value = s.getValue();
            Collections.sort(value, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o2.getFirstName().compareTo(o1.getFirstName());// reverse order we are printing
                }
            });
            collect2.put(s.getKey(), value);
        });
        System.out.println("after sorting");
        System.out.println(collect2);
        System.out.println(collect2.get("Karnataka"));
        Set<String> uniqueDepart = studentList.stream().map(s -> s.getDept()).collect(Collectors.toSet());
        System.out.println(uniqueDepart);

        String s = "raja";
        final String s1 = "ra";
        final String s2 = "ja";
        String s3 = s1.concat(s2);
        System.out.println(s3.hashCode());
        System.out.println(s == s3);
        String s4 = "raja";
        System.out.println(s == s4);
        System.out.println(s.hashCode());
        System.out.println(s4.hashCode());
        if (s == s4) {
            System.out.println("euals");
        }
        if (s == s3) {
            System.out.println("s3 euals");
        }
        String s5 = new String("raja");
        System.out.println(s4 == s5);
        s5.intern();
        System.out.println("after intern");
        System.out.println(s4 == s5);
        System.out.println(s5.hashCode());
        Integer i = new Integer(1);
        Integer i1 = new Integer(1);
        System.out.println(i.hashCode());
        System.out.println(i1.hashCode());
        if (i == i1) {
            System.out.println("both are same");
        }
        Student student = new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929"));
        MpdifyStudent(student);
        System.out.println(student);
        Integer z = new Integer(10);
        MpdifyStudentInteger(z);
        System.out.println(z);
        String s123 = "ramesh";
        ModifyString(s123);
        System.out.println(s123);
        StringBuilder sb = new StringBuilder("abc");
        ModifyStringBulder(sb);
        System.out.println(sb);


        //summ of a list
        OptionalInt reduce1 = IntStream.range(1, 6).reduce((a, b) -> a * b);
        Optional<Integer> reduce = studentList.stream().map(z1 -> z1.getRank()).reduce((a, b) -> a + b);
        System.out.println(reduce1);

    }

    static void MpdifyStudent(Student s) {
        s.setFirstName("raja");
        s.setId(11111);
    }

    static void MpdifyStudentInteger(Integer i) {
        i = 9999;
    }

    static void ModifyString(String i) {
        i = "Juluru";
    }

    static void ModifyStringBulder(StringBuilder i) {
        i.append("rames");
        // i = new StringBuilder("cbaghadh");
    }
}
