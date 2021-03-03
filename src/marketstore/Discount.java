/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketstore;

import java.text.DecimalFormat;



/**
 *
 * @author Folio1040
 */
public class Discount {

    private Card card;
    private int turnover;
    private double discount;
    private double discountRate;
    private int purchaseValue;
    private double total;

    public Discount(Card card, int turnover, int purchaseValue) {
        this.card = card;
        this.turnover = turnover;
        this.purchaseValue = purchaseValue;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calculatePurchase() throws Exception {
        switch (card) {
            case Bronze:
                if (turnover < 100) {
                    discountRate = 0;
                } else if (turnover >= 100 && turnover <= 300) {
                    discountRate = 1;
                } else {
                    discountRate = 2.5;
                }
                doCalculation();
                break;
            case Silver:
                if (turnover <= 300) {
                    discountRate = 2;
                } else {
                    discountRate = 3.5;
                }
                doCalculation();
                break;
            case Gold:
                discountRate = 2;
                int growth = turnover / 100;
                for (int i = 0; i < growth; i++) {
                    if (discountRate < 10) {
                        discountRate++;
                    }
                }
                doCalculation();
                break;
            default:
                System.out.println("N/A");
        }
    }

    private void doCalculation() throws Exception {
        if(purchaseValue<0 || turnover<0 || !(card instanceof Card)){
            throw new Exception("Invalid input!");
        }
        if (discountRate == 0) {
            discount = 0;
            total=purchaseValue;
        }else{
            
            discount=purchaseValue*(discountRate/100);
            
            total=purchaseValue-discount;
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("###.##");
        return "\nCard: "+card+System.lineSeparator()+"\nPurchase value: $"+purchaseValue+System.lineSeparator()+"\nDiscount rate: "+discountRate+"%"+System.lineSeparator()
                +"\nDiscount: $"+df.format(discount)+System.lineSeparator()+"\nTotal: $"+df.format(total);
    }
    
}
