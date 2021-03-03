/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketstore;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Folio1040
 */
public class MarketStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Discount firstClient=new Discount(Card.Bronze, 0, 150);
            firstClient.calculatePurchase();
            Discount secondClient=new Discount(Card.Silver, 600, 850);
            secondClient.calculatePurchase();
            Discount thirdClient=new Discount(Card.Gold, 1500, 1300);
            thirdClient.calculatePurchase();
        } catch (Exception ex) {
            Logger.getLogger(MarketStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
