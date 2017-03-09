package examples;

public class Staff {

    /**
     * Name
     */
    private String name;

    /**
     * Salary
     */
    private Double payment;

    /**
     * Year-end bonus
     */
    private Double bonus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Staff(String name, Double payment, Double bonus) {
        super();
        this.name = name;
        this.payment = payment;
        this.bonus = bonus;
    }
}