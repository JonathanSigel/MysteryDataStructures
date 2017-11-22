import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

public class ContainsMaxTester extends Collection210XTesterImpl {

    public ContainsMaxTester(String canvasID) {
        super("CONTAINS MAX", canvasID);
    }

    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        final long start = CPUClock.getNumTicks();
        dataStructure.contains(2 * n);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}
