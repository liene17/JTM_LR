package jtm.activity10;

/*
TODO Necessary imports commented
 */
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class PersonRepo {

    private List<Person> personList;

    public PersonRepo() {
        init();
    }

    public void init() {

        try {
            // 1. Read file data.json from resources folder into String
            // 2. Use ObjectMapper to convert String to List of Persons and
            // store in personList field
            //Hint: Correct way how to use ObjectMapper to convert String to List below

            Path path = Paths.get(getClass().getClassLoader().getResource("data.json").toURI());
            List<String> lines = (List<String>) Files.readAllLines(path);
            String data = String.join(("\n"), lines);

            ObjectMapper mapper = new ObjectMapper();
            Person[] personArray = mapper.readValue(data, Person[].class);
            personList = Arrays.asList(personArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Person oldestPerson() {
        //Find oldest person in personList field and return it
        Person oldest = personList.stream().min(Comparator.comparing(Person::getBirthDate))
                .orElseThrow(NoSuchElementException::new);
        return oldest;
    }

    public Person youngestPerson() {
        //Find youngest person in personList field and return it
        Person youngest = personList.stream().max(Comparator.comparing(Person::getBirthDate))
                .orElseThrow(NoSuchElementException::new);
        return youngest;
    }

    public String largestPopulation() {
        //Find country with largest population and return it's name
        return null;
    }


}








/*

Hint:
            ObjectMapper mapper = new ObjectMapper();
            Person[] personArray = mapper.readValue(data, Person[].class);
            List<Person> personList = Arrays.asList(personArray);
 */
