import java.util.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.*;

import static java.lang.Math.abs;

public class Practice_8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.1: bank application ///" +
                "////////////////////////////////////////////");
        int balance = 10000;
        BankBalance BankBal = new BankBalance();
        int[] sumsArray = new int[10];
        // Генерация чисел со знаком. Если знак + это пополнение, если знак - снятие.
        for (int i = 0; i < 10; i++) {
            sumsArray[i] = (int)Math.floor(Math.random() * (10000 - (-10000) + 1) + (-10000));
            System.out.println(sumsArray[i]);
        }
        for (int i = 0; i<sumsArray.length; i++) {
            BalanceThread bt = new BalanceThread(BankBal, sumsArray[i]);
            bt.start();
        }
        Thread.sleep(1000);

        System.out.println();
        System.out.println(BankBal.getBalance());
    }
}
