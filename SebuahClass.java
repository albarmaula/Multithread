package com.dojo;

import java.util.ArrayList;

public class SebuahClass implements Runnable{
    private int awal;
    private int setAwal;
    private int penambahan = 2;
    public SebuahClass(int awal) {
        this.awal = awal;
        this.setAwal = awal;
    }
    public  void run() {
        class Letter {
            public int i = awal;
            private String[] abjad = {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                    "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                    "w", "x", "y", "z"
            };
            public int increment(){
                if(this.i + penambahan > 25){
                    this.i = awal;
                    return 1;
                }else{
                    this.i+=penambahan;
                    return 0;
                }
            }

            public String get(){
                if(i<=25){
                    return this.abjad[this.i];
                }else{
                    return "a";
                }
            }
        }
        class Word {
            ArrayList<Letter> letters = new ArrayList<Letter>();
            Word(){
                this.letters.add(new Letter());
            }
            public void increment(){
                int i=0;
                while(this.letters.get(i).increment() == 1) {
                    if (i + 1 < this.letters.size()) {
                        i++;
                        awal = 0;
                        penambahan = 1;
                    } else {
                        awal = 0;
                        penambahan = 1;
                        this.letters.add(new Letter());
                        break;
                    }

                }
            }

            public String get(){
                String hasil = "";
                for(int i=0; i<this.letters.size(); i++){
                    hasil += this.letters.get(i).get();
                }
                return hasil;
            }
        }
        Word word = new Word();
        System.out.println("Masih mencari ...");
        int i = 0;
        while(!Thread.interrupted()&&!Main.pass.equals(word.get())) {
            awal = setAwal;
            penambahan = 2;

            word.increment();
          System.out.println(word.get());
            i++;
        }
        if(Main.pass.equals(word.get())){
            System.out.println("Pencarian Selesai dengan hasil : " + word.get());
        }
        Main.s.interrupt();
        Main.s2.interrupt();
    }
}


