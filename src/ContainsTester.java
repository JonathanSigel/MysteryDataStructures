import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

public class ContainsTester extends Collection210XTesterImpl {

    public ContainsTester(String canvasID) {
        super("CONTAINS", canvasID);
    }

    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Random random = new Random();
        Integer item = random.nextInt(n);

        final long start = CPUClock.getNumTicks();
        dataStructure.contains(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}