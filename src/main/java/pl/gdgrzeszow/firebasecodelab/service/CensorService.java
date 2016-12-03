package pl.gdgrzeszow.firebasecodelab.service;

public interface CensorService {

    /**
     * Censor word by changing not allowed words to stars
     * @param text
     * @return
     */
    String censorWord(String text);

}

