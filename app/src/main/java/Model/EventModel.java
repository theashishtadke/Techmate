package Model;

/**
 * Created by user on 02-09-2016.
 */
public class EventModel {
    private String name;
    private int cost;

    int csi_member;
    int no_of_participants;
    int total_cost;
    int no_payment_due;
    public EventModel() {
    }

    public EventModel(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public EventModel(String name, int cost, int csi_member, int no_of_participants, int total_cost, int no_payment_due) {
        this.name = name;
        this.cost = cost;
        this.csi_member = csi_member;
        this.no_of_participants = no_of_participants;
        this.total_cost = total_cost;
        this.no_payment_due = no_payment_due;
    }

    public int getCsi_member() {
        return csi_member;
    }

    public void setCsi_member(int csi_member) {
        this.csi_member = csi_member;
    }

    public int getNo_of_participant() {
        return no_of_participants;
    }

    public void setNo_of_participant(int no_of_participant) {
        this.no_of_participants = no_of_participant;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public int getNo_payment_due() {
        return no_payment_due;
    }

    public void setNo_payment_due(int no_payment_due) {
        this.no_payment_due = no_payment_due;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}