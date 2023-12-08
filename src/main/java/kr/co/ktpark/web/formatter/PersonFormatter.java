package kr.co.ktpark.web.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PersonFormatter implements Formatter<Person> {

    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        Person person = new Person();
        person.setId(text);
        return person;
    }

    @Override
    public String print(Person person, Locale locale) {
        return person.getId();
    }
}
