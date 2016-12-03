package pl.gdgrzeszow.firebasecodelab.service.impl;

import org.springframework.stereotype.Service;
import pl.gdgrzeszow.firebasecodelab.service.CensorService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CensorServiceImpl implements CensorService {

    final List<String> badWords =
            Arrays.asList("veryBadWord","anotherOne"); //TODO: You can insert here strings to censor

    private Pattern pattern;

    @PostConstruct
    private void init() {
        pattern = Pattern.compile(badWords.stream().collect(Collectors.joining("|")));
    }

    @Override
    public String censorWord(String text) {
        /*
            TODO: Here you can do something with text :)
        */
        return text;
    }
}

