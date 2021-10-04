/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals;

public class Temp {

    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY
    }

    int id;

    @Override
    public int hashCode() {
        class Inner {
            int id;
            public void doStuff() {
                System.out.println(Temp.this.id);
            }
        }
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        Temp t = (Temp) obj;
        return true;
    }

    class Inner {

    }

    public static void main(String[] args) {
        Inner inner = new Temp().new Inner();
    }
}