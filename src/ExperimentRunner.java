import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.*;
import com.cs210x.*;

/**
 * Class to deduce the identity of mystery data structures.
 */
public class ExperimentRunner {
    private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;
    private static final String CS_210X_TEAM_ID_FOR_PROJECT_4 = "ksegenchuk";
    private static int[] N_VALUES = {1, 2, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90,
            100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000,
            6000, 7000, 8000, 9000, 10000}; //size values for testing
    private static int NUM_OF_TESTS = 50;
    public static void main (String[] args) {

        // Fills an array with testers so that the tests can easily be ran through.
        // Tests are divided into classes to factor out commonality and eliminate the need of having to pass a method as a parameter
        final Collection210XTester[] tests = new Collection210XTester[4];
        tests[0] = new AddTester(CS_210X_TEAM_ID_FOR_PROJECT_4);
        tests[1] = new RemoveTester(CS_210X_TEAM_ID_FOR_PROJECT_4);
        tests[2] = new ContainsTester(CS_210X_TEAM_ID_FOR_PROJECT_4);
        tests[3] = new ContainsMaxTester(CS_210X_TEAM_ID_FOR_PROJECT_4);

        // Runs through testers, sizes for n, and the data structures,
        // putting the time it takes for each operation on a data structure of given size
        // in a csv file which can be easily converted to an excel file for making graphs.
        // Also outprints to the console in case you would rather view the data there.
       try {
           PrintWriter testResultsFile = new PrintWriter("testResults.csv", "UTF-8");

           for (int i = 0; i < tests.length; i++) {
               System.out.println("-------" + tests[i].getType() + "-------");
               testResultsFile.println("Data Structures,0,1,2,3,4");
               testResultsFile.println(tests[i].getType());
               for (int k = 0; k < N_VALUES.length; k++) {
                   testResultsFile.print(N_VALUES[k]);
                   for (int j = 0; j < NUM_DATA_STRUCTURES_TO_DEDUCE; j++) {
                       System.out.println("time for length " + N_VALUES[k] + " for Data Structure " + j + " : " + tests[i].runTest(j, N_VALUES[k], NUM_OF_TESTS));
                       testResultsFile.print(",");
                       testResultsFile.print(tests[i].runTest(j, N_VALUES[k], NUM_OF_TESTS));
                   }
                   testResultsFile.print("\n");
               }
           }
           testResultsFile.close();

       }catch (Exception E){
           System.out.println(E.getMessage());
       }

    }
}
