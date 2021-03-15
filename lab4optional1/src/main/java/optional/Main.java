package optional;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton


        List<Student> studentList = new ArrayList<>();
        Set<School> schoolList=new TreeSet<>();
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.name().lastName()) )
                .toArray(Student[]::new);

        studentList.addAll( Arrays.asList(students) );
        studentList.sort(Comparator.comparing(Student::getName));

        School[] schools = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new School("H" + i) )
                .toArray(School[]::new);
        schoolList.addAll(Arrays.asList(schools));

        Map<Student, List<School>> stdPrefMap = new LinkedHashMap<>();
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

        List<School> target = Arrays.asList(schools[0], schools[1]);
        System.out.println("Studentii care prefera scolile H0 si H1 :");
        List<Student> result = studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .collect(Collectors.toList());


        studentList.stream()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .forEach(System.out::println);


        StringBuilder list = new StringBuilder();
        list.append("Scolile care au studentul S2 in topul preferintelor : ");
        List<School> rezultat = schoolList.stream()
                .filter(sch -> schPrefMap.get(sch).indexOf(students[2]) == 0)
                .collect(Collectors.toList());

        //  solutie.algoritm(stdPrefMap,schPrefMap,studentList, (List) schoolList);


    }
}
