package happybit.parser;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {

    protected static final String DELIMITER = "\u0001";
    protected static final String LABEL_SYNTAX = "[a-zA-Z]/";
    protected static final String DATE_FORMAT = "ddMMyyyy";

    protected static final String GOAL_INDEX_FLAG = "g/";
    protected static final String NAME_FLAG = "n/";
    protected static final String GOAL_TYPE_FLAG = "f/";
    protected static final String INTERVAL_FLAG = "i/";
    protected static final String START_DATE_FLAG = "s/";
    protected static final String END_DATE_FLAG = "e/";

    /**
     * Splits the input into the various parameters.
     *
     * @param input User input.
     * @return String array containing the parameters.
     */
    protected static String[] splitInput(String input) {
        Function<MatchResult, String> replace = x -> DELIMITER + x.group();
        Pattern pattern = Pattern.compile(LABEL_SYNTAX);
        Matcher matcher = pattern.matcher(input);
        String processedInput = matcher.replaceAll(replace);
        String[] parameters = processedInput.split(DELIMITER);
        return trimParameters(parameters);
    }

    /**
     * Removes leading and trailing whitespaces if any.
     *
     * @param parameters String array of command parameters.
     * @return String array of command parameters that have been trimmed of leading/trailing whitespaces.
     */
    private static String[] trimParameters(String[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = parameters[i].trim();
        }
        return parameters;
    }

    /**
     * Finds the parameters corresponding to the given label and returns it.
     *
     * @param parameters String array of command parameters.
     * @param label      Label of a parameter.
     * @return Parameter if it exists, null otherwise.
     */
    protected static String getParameter(String[] parameters, String label) {
        for (String parameter : parameters) {
            if (parameter.contains(label)) {
                return parameter;
            }
        }
        return null;
    }

}
