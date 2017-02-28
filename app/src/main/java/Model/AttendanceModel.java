package Model;

/**
 * Created by user on 02-09-2016.
 */
public class AttendanceModel {
    String name;
    String status;
    String key;

    public AttendanceModel(String name, String status, String key) {
        this.name = name;
        this.status = status;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public AttendanceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
