import java.util.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Practice_7 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: replace words of certain length ///" +
                "////////////////////////////////////////////");
        int word_length = 3;
        String text = "And wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart? I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. When,";
        String setted_substring = " REPLACING ";
        String new_text = text.replaceAll("^[a-zA-Z]{3} ", setted_substring);
        String new_new_text = new_text.replaceAll("[\b .,:;!?-][a-zA-Z]{3}[\b .,:;!?-]", setted_substring);
        System.out.println(new_new_text);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: substring after k-symbol ///" +
                "////////////////////////////////////////////");
        String k_text = text;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k_text.length(); i++) {
            if (i == 3) {
                stringBuilder.append(setted_substring);
            }
            stringBuilder.append(k_text.charAt(i));
        }
        // Не работает из-за наличия пробелов
        //String k_text = text.replaceAll("([ ,a-zA-Z]{3})([ ,a-zA-Z]{497})", "$1 REPLACING $2");
        System.out.println(stringBuilder);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: vowels or events ///" +
                "////////////////////////////////////////////");
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            String sent = text.substring(start,end);
            System.out.println("Sentence: " + text.substring(start,end));
            System.out.println(sent.replaceAll("[^aeiouAEIOU]", "").length());
            System.out.println(sent.replaceAll("[^BbCcDdFfGgJjKkLlMmNnPpQqSsTtVvXxZzHhRrWwYy]", "").length());
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.5: words begin and end with vowels ///" +
                "////////////////////////////////////////////");
        BreakIterator w_iterator = BreakIterator.getWordInstance(Locale.US);
        w_iterator.setText(text);
        int w_start = w_iterator.first();
        int w_count = 0;
        for (int end = w_iterator.next(); end != BreakIterator.DONE; w_start = end, end = w_iterator.next()) {
            String word = text.substring(w_start, end);
            //System.out.println("word: " + text.substring(w_start, end));
            int end_vowel = word.substring(word.length() - 1).replaceAll("[^aeiouAEIOU]", "").length();
            int begin_vowel = word.substring(0, 1).replaceAll("[^aeiouAEIOU]", "").length();
            if (end_vowel == 1 && begin_vowel == 1) {
                w_count++;
            }
        }
        System.out.println("Count of words with beginning and ending of vowels equals " + w_count);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.4: words with length = 3 ///" +
                "////////////////////////////////////////////");
        Pattern pattern = Pattern.compile("(\\b\\w{3}\\b)");
        BreakIterator new_iterator = BreakIterator.getSentenceInstance(Locale.US);
        new_iterator.setText(text);
        int n_start = iterator.first();
        for (int end = new_iterator.next(); end != BreakIterator.DONE; n_start = end, end = new_iterator.next()) {
            String sent = text.substring(n_start,end);
            if ((sent.substring(sent.length() - 2)).equals("? ")) {
                Matcher matcher = pattern.matcher(sent);
                while (matcher.find()) {
                    System.out.println(matcher.group(1));
                }
            }
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.5: replace last and first words ///" +
                "////////////////////////////////////////////");
        int f_start = new_iterator.first();
        for (int end = new_iterator.next(); end != BreakIterator.DONE; f_start = end, end = new_iterator.next()) {
            String sent = text.substring(f_start,end);
            System.out.println(sent);
            String last_w = sent.replaceAll("(^.*?)(\\w+)\\W*$", "$2");
            String first_w = sent.replaceAll("^\\W*\\b(\\w+)(.*)", "$1");
            String new_sent = sent.replaceAll("(^.*?)(\\w+)(\\W*$)", "$1" + first_w + "$3");
            String new_sent_sec = new_sent.replaceAll("^\\W*\\b(\\w+)(.*)", last_w + "$2");
            System.out.println(new_sent_sec);
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.4: find a word with symbols on the end and start ///" +
                "////////////////////////////////////////////");
        BreakIterator es_iterator = BreakIterator.getWordInstance(Locale.US);
        es_iterator.setText(text);
        int es_start = es_iterator.first();
        int max_len = 0;
        int start_ind = 0;
        int end_ind = 0;
        for (int end = es_iterator.next(); end != BreakIterator.DONE; es_start = end, end = es_iterator.next()) {
            String word = text.substring(es_start, end);
            System.out.println(word);
            System.out.println(word.substring(word.length() - 1));
            System.out.println(word.substring(0, 1));
            int end_with_e = word.substring(word.length() - 1).replaceAll("[^eE]", "").length();
            int begin_with_i = word.substring(0, 1).replaceAll("[^iI]", "").length();
            if (end_with_e == 1 && begin_with_i == 1) {
                if (max_len == 0) {
                    max_len = word.length();
                    start_ind = es_start;
                    end_ind = end;
                }
                else {
                    if (max_len < word.length()) {
                        max_len = word.length();
                        start_ind = es_start;
                        end_ind = end;
                    }
                }
            }
        }
        System.out.println(text.substring(start_ind, end_ind));

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.5: replace duplicate symbols ///" +
                "////////////////////////////////////////////");
        String dupl_repl = text.replaceAll("(?i)([a-z]+)(?:\\1)+", "REPLACING");
        System.out.println(dupl_repl);
    }
}
