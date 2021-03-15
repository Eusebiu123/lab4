package compulosry;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Set<School> schoolList=new TreeSet<>();
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);

        studentList.addAll( Arrays.asList(students) );
        studentList.sort(Comparator.comparing(Student::getName));

        School[] schools = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);
        for(School s : schools){
            schoolList.add(s);
        }

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        List<School> prefList0 = new ArrayList<>();
        List<School> prefList1 = new ArrayList<>();
        List<School> prefList2 = new ArrayList<>();
        prefList0.add(schools[0]);
        prefList0.add(schools[1]);
        prefList0.add(schools[2]);
        prefList1.add(schools[0]);
        prefList1.add(schools[1]);
        prefList2.add(schools[0]);
        prefList2.add(schools[2]);
        stdPrefMap.put(students[0], prefList0);
        stdPrefMap.put(students[1], prefList0);
        stdPrefMap.put(students[2], prefList1);
        stdPrefMap.put(students[3], prefList2);


        Map<School, List<Student>> schPrefMap = new HashMap<>();
        schPrefMap.put(schools[0], Arrays.asList(students[3],students[0],students[1],students[2]));
        schPrefMap.put(schools[1], Arrays.asList(students[0],students[2],students[1]));
        schPrefMap.put(schools[2], Arrays.asList(students[0],students[1],students[3]));
    }
}
