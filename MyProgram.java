/*
Create an application that reads and then displays
the contents of a file containing records with the 
firstname, last name and scores for students into 3 parrallel arrays.
Use Notepad or some other word processor to create the file.
The program will display the file sorted by score (ascending order)
and calculate an average.
 */
 
import java.io.*;

public class MyProgram {

    public static void main(String[] agrs) {
        FileReader in;
        BufferedReader readFile;
        String[] FIRST = new String[25];
        String[] LAST = new String[25];
        int[] SCORES = new int[25];
        String tmpFIRST, tmpLAST, tmpSCORES;
        String lineOfText;
        int c = 0;
        String TEMPfirst, TEMPlast;
        int TEMPscores;
        try {
            in = new FileReader("C:\\Users\\lenovo\\Documents\\StuScores2.txt");
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null) {
                c += 1;
                tmpFIRST = lineOfText.substring(0, 10);
                tmpLAST = lineOfText.substring(10, 20);
                tmpSCORES = lineOfText.substring(20, 22);
                FIRST[c] = tmpFIRST;
                LAST[c] = tmpLAST;
                SCORES[c] = Integer.parseInt(tmpSCORES);
            }
            for (int i = 1; i <= c - 1; i++) {
                for (int j = i + 1; j <= c; j++) {
                    if (SCORES[j] < SCORES[i]) {
                        TEMPscores = SCORES[j];
                        SCORES[j] = SCORES[i];
                        SCORES[i] = TEMPscores;
                        TEMPfirst = FIRST[j];
                        FIRST[j] = FIRST[i];
                        FIRST[i] = TEMPfirst;
                        TEMPlast = LAST[j];
                        LAST[j] = LAST[i];
                        LAST[i] = TEMPlast;
                    }
                }
            }
            double totalScore = 0;
            double avgScore;
            System.out.println("Student Scores File");
            System.out.println();
            System.out.println("First Name    Last Name    Score");
            System.out.println();
            for (int i = 1; i <= c; i++) {
                System.out.printf("%-14s%-13s%5d\n", FIRST[i], LAST[i], SCORES[i]);
                totalScore += SCORES[i];
            }
            avgScore = totalScore / c;
            System.out.println();
            System.out.println("Avegrage Score: " + avgScore);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
