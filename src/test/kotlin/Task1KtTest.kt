import org.junit.Test

import org.junit.Assert.*

class Task1KtTest {

    @Test
    fun testMastercardSmallAmountNoCommission() {
        assertEquals(0, transaction("Mastercard", 0, 300))
    }

    @Test
    fun testMastercardSmallAmountWithCommission() {
        assertEquals(20, transaction("Mastercard", 0, 100)) //100+200 is 300
    }

    @Test
    fun testMastercardLargeAmountWithCommission() {
        assertEquals(98, transaction("Mastercard", 0, 130000))
    }

    @Test
    fun testMaestroLimit() {
        assertEquals(0, transaction("Maestro", 0, 75000))
    }

    @Test
    fun testMaestroSmallAmount() {
        assertEquals(0, transaction("Maestro", 70000, 100))
    }


    @Test
    fun testVisaSmallAmount() {
        assertEquals(35, transaction("Visa", 0, 1000))
    }

    @Test
    fun testVisaLargeAmount() {
        assertEquals(637, transaction("Visa", 0, 85000))
    }


    @Test
    fun testMirSmallAmount() {
        assertEquals(35, transaction("Мир", 0, 1000))
    }

    @Test
    fun testMirLargeAmount() {
        assertEquals(637, transaction("Мир", 0, 85000))
    }

    @Test
    fun testVKPaySmallAmount() {
        assertEquals(0, transaction("VK Pay", 0, 1000))
    }

    @Test
    fun testVKPayLimitExceeded() {
        assertEquals(-1, transaction("VK Pay", 4000000, 1))
    }


    @Test
    fun testAmountLimitExceeded() {
        assertEquals(-1, transaction("Mastercard", 0, 150001))
    }

    @Test
    fun testTotalLimitExceeded() {
        assertEquals(-1, transaction("Visa", 6000000, 1))
    }


    @Test
    fun testUnknownCardType() {
        assertEquals(-2, transaction("Unknown", 0, 1000))
    }
}

