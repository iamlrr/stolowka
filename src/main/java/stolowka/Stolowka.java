package stolowka;

public class Stolowka {
    private int customers;
    private double mealPrice = 5;
    public static final int DAYS = 22;
    public int cancellations = 0;
    private int mealsToday;
    private int mealsCurrentMonth;
    private double paymentNextMonth;
    private int mealsTomorrow;
    private double paymentThisMonth;

    public Stolowka(int customers) {
        this.customers = customers;
        this.mealsToday = customers;
        this.mealsCurrentMonth = customers * DAYS;
        this.paymentNextMonth = customers * DAYS * mealPrice;
        this.paymentThisMonth = customers * DAYS * mealPrice;
    }

    public void cancelMeals(int cancellations) {
        this.cancellations += cancellations;
        this.mealsTomorrow = mealsToday - cancellations;
        this.paymentNextMonth -= cancellations * this.mealPrice;

    }

    public int getMealsForToday() {
        return mealsToday;
    }

    public int getMealsTomorrow() {
        return mealsTomorrow;
    }

    public int getMealsForThisMonth() {
        return this.mealsCurrentMonth;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public double getPaymentThisMonth() {
        return paymentThisMonth;
    }

    public double getPaymentNextMonth() {
        return paymentNextMonth;
    }
}
