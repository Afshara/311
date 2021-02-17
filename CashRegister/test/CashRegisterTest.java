import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    @Test
    public void test1(){
        CashRegister cashRegister = new CashRegister();
        double result = cashRegister.purchaseItem(50.10,BillPack.fifties(), CoinPack.quarters());
        assertEquals(0.15, result);
    }

    @Test
    public static void test12(){
        CashRegister cashRegister = new CashRegister();
        double result = cashRegister.purchaseItem(-50.10,BillPack.fifties(), CoinPack.quarters());
        assertNull([String "Notvalid"], result);

    }

    @Test
    public static void test2(){
        CashRegister cashRegister = new CashRegister();
        double result = cashRegister.finalizePurchase();
        assertEquals("onetwo", result);
    }

    @Test
    public static void test3(){
        CashRegister cashRegister = new CashRegister();
        double result = cashRegister.scanItem();
        assertEquals("onetwo", result);
    }

    @Test
    public static void whenExceptionThrown_thenAssertionSucceeds(){
        String test = null;
        assertThrows(NullPointerException.class,() ->{});
    }

}