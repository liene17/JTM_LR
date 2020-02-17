package jtm.activity11;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Before
    public void setUp() {
        VendingMachine vendingMachine = new VendingMachine();
    }

    @Test
    public void testBalanceFormat(){
        String result = String.format(".%2f$",this.coinsInMachine);


    }


}
