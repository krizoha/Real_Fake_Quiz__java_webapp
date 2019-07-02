package cz.java_webapp.realfakequiz;

import java.io.*;
import java.util.*;
import org.springframework.core.io.*;
import org.springframework.core.io.support.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class MainController {

    private List<Picture> listOfPictures;

    public MainController() throws IOException {
        ResourcePatternResolver seekPicture = new PathMatchingResourcePatternResolver();
        List<Resource> photoBank = Arrays.asList(seekPicture.getResources("classpath:/static/images/photos/*"));
        listOfPictures = new ArrayList<>(photoBank.size());

        for (Resource oneResource : photoBank) {

            listOfPictures.add(new Picture(oneResource));
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndex() {
        ModelAndView dataHolder = new ModelAndView("index");
        dataHolder.addObject("pictures", listOfPictures);
        return dataHolder;
    }

    @RequestMapping(value = "/nature{number:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Resource showPicture(@PathVariable int number) {
        return listOfPictures.get(number).getPicture();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView showResults(IndexForm entryData) {
        int score = 0;

        for (int i = 0; i < listOfPictures.size(); i++) {
            Picture obr = listOfPictures.get(i);
            Picture.TypeOfPicture answer = entryData.getAnswers().get(i);
            if (obr.getType().equals(answer)) {
                score++;
            }
        }

        ModelAndView dataHolder = new ModelAndView("results");
        dataHolder.addObject("totalScore", score);
        dataHolder.addObject("totalNumberOfPictures", listOfPictures.size());

        return dataHolder;
    }

    @RequestMapping(value = "/correct_answers.html")
    public ModelAndView showCorrectAnswers() {
        ModelAndView dataHolder = new ModelAndView("correct_answers");
        dataHolder.addObject("pictures", listOfPictures);
        return dataHolder;
    }

}
