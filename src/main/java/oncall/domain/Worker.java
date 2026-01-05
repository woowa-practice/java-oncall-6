package oncall.domain;

import java.util.Collections;
import java.util.List;

public class Worker {
    private final List<String> names;
    private int index = 0;

    public Worker(List<String> names) {
        this.names = names;
    }

    public String checkNext() {
        return names.get(index % names.size());
    }

    public String getNextAndMove() {
        String worker = checkNext();
        index++;
        return worker;
    }

    public void swap() {
        int curIdx = index % names.size();
        int nextIdx = (index + 1) % names.size();

        Collections.swap(names, curIdx, nextIdx);
    }
}
