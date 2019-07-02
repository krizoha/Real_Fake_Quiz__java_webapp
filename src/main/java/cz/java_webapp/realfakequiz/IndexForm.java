package cz.java_webapp.realfakequiz;

import java.util.*;

public class IndexForm {

    private List<Picture.TypeOfPicture> answers;

    public List<Picture.TypeOfPicture> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Picture.TypeOfPicture> newValue) {
        answers = newValue;
    }
}
