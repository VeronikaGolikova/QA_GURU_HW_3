package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRundomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRundomPhoneNumber(int len) {
        String symbol = "0123456789";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++)
            result.append(symbol.charAt(rnd.nextInt(symbol.length())));

        return result.toString();
    }

    public static String getRundomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        int index = getRandomInt(0, month.length - 1);
        return month[index];
    }

    public static String getRundomDate() {
        String rundomDate = String.valueOf(getRandomInt(1, 28));
        if (rundomDate.length() == 1) {
            rundomDate = "0" + rundomDate;
        };
        return rundomDate;
    }

    public static String getRundomLetterForSubj() {
        String[] subj = {"e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "g", "h", "l", "c", "v", "b", "n", "m"};
        int index = getRandomInt(0, subj.length - 1);
        return subj[index];
    }

    public static String getRundomHobbie() {
        String[] hobbie = {"Sports", "Reading", "Music"};
        int index = getRandomInt(0, hobbie.length - 1);
        return hobbie[index];
    }

    public static String getRundomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = getRandomInt(0, state.length - 1);
        return state[index];
    }

    public static String getRundomCity(String state) {
        String[] city = null;
        if(state.equals("NCR")) {
            city = new String[]{"Delhi", "Gurgaon", "Noida"};
        } else if (state.equals("Uttar Pradesh")) {
            city = new String[]{"Agra", "Lucknow", "Merrut"};
        } else if (state.equals("Haryana")) {
            city = new String[]{"Karnal", "Panipat"};
        } else if (state.equals("Rajasthan")) {
            city = new String[]{"Jaipur", "Jaiselmer"};
        }
        int index = getRandomInt(0, city.length - 1);
        return city[index];
    }
}
