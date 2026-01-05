package oncall.domain;

import java.util.Collections;
import java.util.List;

public class Yoil {
    private List<String> yoil;

    public Yoil(List<String> yoil){
        this.yoil=yoil;
    }

    public List<String> getYoil() {
        return Collections.unmodifiableList(yoil);
    }
}
