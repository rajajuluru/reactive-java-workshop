package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        Stream<Integer> integerStream = StreamSources.intNumbersStream();
        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        integerStream.forEach(data -> System.out.println(data));


        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("less than 5");
        StreamSources.intNumbersStream().filter(data1 -> data1 < 5).forEach(data2 -> System.out.println(data2));
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println(" second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(data1 -> data1 > 5).skip(1).limit(2).forEach(data3 -> System.out.println(data3));
        //Executors.newVirtualThreadPerTaskExecutor();
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("first element after 5");
        System.out.println(StreamSources.intNumbersStream().filter(data1 -> data1 > 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        // TODO: Write code here

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

    }

}
