package io.javabrains.reactiveworkshop;

import java.util.*;
import java.util.stream.Collectors;
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

    }
}
