import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by John on 04/12/2017.
 */
public class ReadUnit {


    /*
    Read textfile and return a String array with each element being a line from file.
    */
    public String[] ReadFile(String filename) throws IOException{
        java.io.FileReader reader = new java.io.FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        java.io.FileReader reader2 = new java.io.FileReader(filename);
        BufferedReader buffer2 = new BufferedReader(reader2);

        String string;
        int lineCount = 0;
        while ((string = buffer2.readLine()) != null) {
            lineCount++;
        }

        String[] textData = new String[lineCount];
        // Read each line as its own element
        for (int i = 0; i < lineCount; i++) {
            textData[i] = buffer.readLine();
        }

        reader.close();
        return textData;
    }


    /*
    Read textfile and return a String array with each element being a line from file, starting from line containing 'from'.
     */
    public String[] ReadFile(String filename, String from) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        FileReader reader2 = new FileReader(filename);
        BufferedReader buffer2 = new BufferedReader(reader2);

        String string;
        int lineCount = 0;
        while ((string = buffer2.readLine()) != null) {
            lineCount++;
        }

        String[] textData = new String[lineCount];
        // Read each line as its own element
        for (int i = 0; i < lineCount; i++) {
            textData[i] = buffer.readLine();
        }

        String[] lang = new String[25]; //Hardcoded so far
        for (int i = 0; i < textData.length; i++) {
            if(textData[i].contains(from)) {
                for (int j = 0; !(textData[i + 1 + j].contains("--")); j++) {
                    lang[j] = textData[i+1+j];
                }
                break;
            }
        }

        reader.close();
        return lang;
    }
    /*
Read text file and return an int of how many occurrences of the search term is in the file.
*/
    public int countInFile(String filename, String searchTerm) throws IOException{
        java.io.FileReader reader = new java.io.FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);

        String string;
        int hits = 0; //Number of occurrences of search term in text file
        while ((string = buffer.readLine()) != null) {
            if (string.contains(searchTerm)){
                hits++;
            }
        }

        reader.close();
        return hits;
    }

    /*
Read text file and return a String array with each element being a language present in the file.
 */
    public String[] getLanguageList(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        FileReader reader2 = new FileReader(filename);
        BufferedReader buffer2 = new BufferedReader(reader2);

        String string;
        int lineCount = 0;
        while ((string = buffer2.readLine()) != null) {
            lineCount++;
        }

        String[] textData = new String[lineCount];
        // Read each line as its own element
        for (int i = 0; i < lineCount; i++) {
            textData[i] = buffer.readLine();
        }

        int j = 0;
        String[] lang = new String[25]; //Hardcoded so far
        for (int i = 0; i < textData.length; i++) {
            if(textData[i].contains("--") && !textData[i].contains("endoffile")) {
                lang[j] = textData[i].replace("--", ""); //remove indicator from language name
                lang[j] = "("+(j+1)+")"+lang[j].substring(0, 1).toUpperCase() + lang[j].substring(1); //grammar correction + number
                j++;
            }
        }

        reader.close();
        return lang;
    }

    /*
Read text file and return a String array with each element being a language present in the file.
 */
    public String[] getLanguages(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(reader);
        FileReader reader2 = new FileReader(filename);
        BufferedReader buffer2 = new BufferedReader(reader2);

        String string;
        int lineCount = 0;
        while ((string = buffer2.readLine()) != null) {
            lineCount++;
        }

        String[] textData = new String[lineCount];
        // Read each line as its own element
        for (int i = 0; i < lineCount; i++) {
            textData[i] = buffer.readLine();
        }

        int j = 0;
        String[] lang = new String[25]; //Hardcoded so far
        for (int i = 0; i < textData.length; i++) {
            if(textData[i].contains("--") && !textData[i].contains("endoffile")) {
                lang[j] = textData[i].replace("--", ""); //remove indicator from language name
                j++;
            }
        }

        reader.close();
        return lang;
    }
}