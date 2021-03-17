package com.learn.jichu;

public class Pizza {
    public PizzaStatus status;
    public Pizza(){

    }
   public Pizza(PizzaStatus pizzaStatus){
        this.status = pizzaStatus;
    }

    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.isDeliverable();
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

}
