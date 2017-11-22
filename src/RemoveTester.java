import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

import java.util.Random;

public class RemoveTester extends Collection210XTesterImpl {

    public RemoveTester(String canvasID) {
        super("REMOVE", canvasID);
    }

    @Override
    protected long timeTest(Collection210X dataStructure, int n)
    {
        Random random = new Random(CPUClock.getNumTicks());
        Integer item = random.nextInt(2 * n);

        if (item % 2 != 0) {
            item = item ++;
        }

        final long start = CPUClock.getNumTicks();
        dataStructure.remove(item);
        final long end = CPUClock.getNumTicks();

        return end - start;
    }
}