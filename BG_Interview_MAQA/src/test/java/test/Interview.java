package test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Interview {

    public static void main(String[] args) {

        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People(6, "Kolia"));
        peopleList.add(new People(12, "Igor"));
        peopleList.add(new People(28, "Sergey"));

        List<String> collect = peopleList.stream().map(People::getName).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

        List<People> collect1 = peopleList.stream().filter(x -> x.getAge() > 15).collect(Collectors.toList());
        System.out.println(collect1);

        boolean b = peopleList.stream().anyMatch(x -> x.getAge() < 10);
        System.out.println(b);

        OptionalDouble average = peopleList.stream().mapToInt(x -> x.getAge()).average();
        System.out.println(average);
    }


    public static class People {
        private int age;
        private String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "People{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
