package Core.UI;

import static Core.Main.*;

public class Validator {
    private static final int NO_ERROR = 0;
    public static final int WRONG_USAGE = 1;
    public static final int WRONG_CONVERT_DIRECTION = 2;
    private final String[] args;
    private int mainError = NO_ERROR;

    public Validator(String[] args) {
        this.args = args;
    }


    public boolean hasErrors() {
        if (args.length != 3) {
            mainError = WRONG_USAGE;
            return true;
        }

        if (!args[CONVERT_DIRECTION].equals(TO_DOXYGEN) && !args[CONVERT_DIRECTION].equals(TO_CPP)) {
            mainError = WRONG_CONVERT_DIRECTION;
            return true;
        }

        return false;
    }

    public int getMainError() {
        return mainError;
    }
}
