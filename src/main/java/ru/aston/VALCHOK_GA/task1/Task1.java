package ru.aston.VALCHOK_GA.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    private static Stream<Car> carStream;

    @BeforeEach
    void init(){
        carStream = Stream.of(
                new Car("Toyota","Supra","2JZ-GTE V6", 3.0F,280),
                new Car("Honda","NSX","C30A V6",3.0F,280),
                new Car("Nissan","Skyline GTR R34","RB26-DETT I6",2.6F,280),
                new Car("Mazda","RX7 FD","13B-REW ROTOR", 1.3F,280),
                new Car("Nissan","350Z","VQ35HR V6", 3.5F, 313),
                new Car("Mitsubishi","Lancer EVO9","4G63T I4",2.0F,280),
                new Car("Subaru","Impreza GD/G11","EJ207 B4",2.0F,320),
                new Car("Audi","RS6","BRV V8",4.2F,480)
        );
    }

    @Test
    @DisplayName("Вывести все четные числа в диапазоне от 1 до 100")
    void allEvenFrom0to10(){
        Stream<Integer> myStream = Stream
                .iterate(1, i -> i+1)
                .limit(100)
                .filter(i -> i % 2 == 0);
        myStream.forEach(System.out::println);
    }

    @Test
    @DisplayName("Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию")
    void sortAscending(){
        Stream<Integer> myStream = Stream.of(7,9,5,1,3);
        myStream
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Выведите все нечетные числа в заданном массиве")
    void oddNumbers(){
        Stream<Integer> myStream = Stream.of(145,15,47,68,34,125,288,1,35,54,17);
        myStream
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1")
    void filterBySomething (){
        carStream
                .filter(p -> p.getManufacturer().equals("Nissan"))
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Проверить, все ли числа в массиве [0, 1, …, 19] являются четными")
    void isAllEven(){
        Stream<Integer> myStream = Stream
                .iterate(0, i -> i+1)
                .limit(19);
        if(myStream.allMatch(i -> i%2 == 0))
            System.out.println("All numbers are even");
        else
            System.out.println("Not all numbers are even");
    }

    @Test
    @DisplayName("Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года")
    void datesStream(){
        Stream<Integer> datesInMonth = Stream
                .iterate(1, i -> i+1)
                .limit(12)
                .map(i -> YearMonth.of(2025,i).lengthOfMonth());
        datesInMonth.forEach(System.out::println);
    }

    @Test
    @DisplayName("Создайте два Stream-а: один из массива чисел 1…5, второй из массива 5…10. Объедините эти два Stream-а в один и выведите на экран")
    void twoStreams(){
        Stream<Integer> firstStream = Stream.of(1,2,3,4,5);
        Stream<Integer> secondStream = Stream.of(5,6,7,8,9,10);
        Stream<Integer> unitedStreams = Stream.concat(firstStream, secondStream);
        unitedStreams.forEach(System.out::println);
    }

    @Test
    @DisplayName("Создать стрим из массива чисел и вывести на экран только числа, которые больше 10 и меньше 20")
    void between10and20(){
        Stream<Integer> myStream = Stream.of(1, 14, 35, 245, 0, 18, 65, 15);
        myStream
                .filter(i -> i > 10 && i < 20)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Создать три стрима из массивов чисел от 1 до 10, от 10 до 20 и от 20 до 30 соответственно. Объединить их в один стрим и вывести числа, которые кратны 5")
    void threeStreamsByFive(){
        Stream<Integer> firstStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> secondStream = Stream.of(10,11,12,13,14,15,16,17,18,19,20);
        Stream<Integer> thirdStream = Stream.of(20,21,22,23,24,25,26,27,28,29,30);
        Stream<Integer> unitedStreams = Stream.concat(firstStream, secondStream);
        unitedStreams = Stream.concat(unitedStreams, thirdStream);
        unitedStreams
                .filter(i -> i%5 == 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Создание двух Stream из массивов целых чисел и объединение их в один, затем вывод на экран суммы квадратов элементов этого Stream")
    void twoStreamsWithSquareSum(){

        Stream<Integer> firstStream = Stream.of(2,3,4,5,6);
        Stream<Integer> secondStream = Stream.of(7,8,9,10,11,12,13);
        firstStream = Stream.concat(firstStream, secondStream);
        Optional<Integer> sum = firstStream
                .map(i -> i*i)
                .reduce(Integer::sum);
        System.out.println(sum);
    }

/*    @Test
    @DisplayName("Сгруппировать слова в Stream по первой букве, посчитать количество слов в каждой группе и вывести результаты в виде словаря, где ключ — первая буква слова, а значение — количество слов, начинающихся на эту букву")
    void  groupWords(){
        Stream<String> words = Stream.of("книга", "буква","слово","количество","группа","результат","компьютер","жизнь","вода","карандаш","салют","рука","стол","кресло","запанки","животное","человек");
        words.sorted();
        Map<Character, Integer> dictionary = Collectors.toMap(words, );

    }*/
}
