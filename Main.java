package com.dojo;

import javax.xml.xpath.XPathEvaluationResult;
import java.util.Scanner;

public class Main {
    public static String pass = "";
    public static Thread s;
    public static Thread s2;

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan Password :");
        pass = a.next();

        SebuahClass t = new SebuahClass(0);
        SebuahClass t2 = new SebuahClass(1);

        s = new Thread(t);
        s2 = new Thread(t2);

        s.start();
        s2.start();
    }
}
