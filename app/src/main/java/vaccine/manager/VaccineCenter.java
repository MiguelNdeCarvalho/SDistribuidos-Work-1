package vaccine.manager;

import java.util.LinkedList;
import java.util.List;

/**
 * VaccineCenter
 */
public class VaccineCenter {

    String Region;
    LinkedList<Client> Queue = new LinkedList<>();

    public int getQueueSize(){
        return this.Queue.size();
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }
}