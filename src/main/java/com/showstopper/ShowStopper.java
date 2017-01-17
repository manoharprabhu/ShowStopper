package com.showstopper;

import ru.lanwen.verbalregex.VerbalExpression;

import java.util.regex.Pattern;

/**
 * Created by manoharprabhu on 1/17/2017.
 */
public class ShowStopper {

    public static Show identify(String fileName) {
        String delimiter = getNameDelimiter(fileName);
        String showName = getShowName(fileName, delimiter);
        int seasonNumber = getSeasonNumber(fileName, delimiter);
        int episodeNumber = getEpisodeNumber(fileName, delimiter);
        String extension = getExtension(fileName, delimiter);
        return new Show(showName, seasonNumber, episodeNumber, extension);
    }

    private static String getExtension(String fileName, String delimiter) {
        if(fileName.length() < 5) {
            return "";
        }

        if(fileName.charAt(fileName.length() - 4) != '.') {
            return "";
        }

        return fileName.substring(fileName.length() - 3);
    }

    private static int getEpisodeNumber(String fileName, String delimiter) {
        if(delimiter == null) {
            return 0;
        }
        VerbalExpression expression = VerbalExpression.regex()
                .oneOf("e", "E")
                .digit().oneOrMore()
                .oneOf(delimiter, ".")
                .build();
        String episodeText = expression.getText(fileName);
        VerbalExpression digitExpression = VerbalExpression.regex()
                .digit().oneOrMore()
                .build();
        String digits = digitExpression.getText(episodeText);
        if("".equals(digits)) {
            return 0;
        }
        return Integer.valueOf(digits);
    }

    private static int getSeasonNumber(String fileName, String delimiter) {
        if(delimiter == null) {
            return 0;
        }
        VerbalExpression expression = VerbalExpression.regex()
                .oneOf("s", "S")
                .digit().oneOrMore()
                .build();
        String seasonText = expression.getText(fileName);
        VerbalExpression digitExpression = VerbalExpression.regex()
                .digit().oneOrMore()
                .build();
        String digits = digitExpression.getText(seasonText);
        if("".equals(digits)) {
            return 0;
        }
        return Integer.valueOf(digits);
    }

    private static String getShowName(String fileName, String delimiter) {
        VerbalExpression expression = VerbalExpression.regex()
                .oneOf("s", "S")
                .digit().oneOrMore()
                .build();
        String seasonText = expression.getText(fileName);

        if("".equals(seasonText)) {
            if(fileName.length() < 5) {
                return "";
            }

            if(fileName.charAt(fileName.length() - 4) != '.') {
                return "";
            }

            return fileName.substring(0, fileName.length() - 4);
        }

        String name = fileName.substring(0, fileName.indexOf(seasonText));

        String[] parts = name.split(Pattern.quote(delimiter));
        if(!"".equals(name)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                builder.append(parts[i]);
                builder.append(" ");
            }
            return builder.toString().trim();
        } else {
            if(fileName.length() < 5) {
                return "";
            }

            if(fileName.charAt(fileName.length() - 4) != '.') {
                return "";
            }

            return fileName.substring(0, fileName.length() - 4);
        }
     }

    private static String getNameDelimiter(String fileName) {
        if(fileName.length() < 5) {
            return null;
        }
        for(char c : fileName.substring(0, fileName.length() - 4).toCharArray()) {
            if(c == '.') {
                return ".";
            }
            if(c == '_') {
                return "_";
            }
            if(c == '-') {
                return "-";
            }
        }
        return " ";
    }
}
