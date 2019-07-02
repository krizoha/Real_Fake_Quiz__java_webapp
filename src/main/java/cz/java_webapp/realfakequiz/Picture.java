package cz.java_webapp.realfakequiz;

import org.springframework.core.io.*;

public class Picture {

    public static final String REAL = "-real";
    public static final String FAKE = "-fake";

    private Resource picture;
    private TypeOfPicture type;

    //////////////////////////////////////////////////////////////////

    public static enum TypeOfPicture {
        REAL_PICTURE, FAKE_PICTURE
    }

    //////////////////////////////////////////////////////////////////

    public Resource getPicture() {
        return picture;
    }

    public TypeOfPicture getType() {
        return type;
    }

    //////////////////////////////////////////////////////////////////

    public Picture(Resource pic) {
        String nameOfPicture = pic.getFilename();

        if (nameOfPicture.contains(REAL)) {
            this.type = TypeOfPicture.REAL_PICTURE;
        } else if (nameOfPicture.contains(FAKE)) {
            this.type = TypeOfPicture.FAKE_PICTURE;
        } else {
            throw new IllegalStateException("Invalid file name.");
        }

        picture = pic;
    }
}
