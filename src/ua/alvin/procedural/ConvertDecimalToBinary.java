package ua.alvin.procedural;

import java.math.BigInteger;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {

        byte octet = 5;
        String oc = Integer.toBinaryString(octet);
        String bin = String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0');
        byte data = 0b101;
        System.out.println(data);
        System.out.println(oc);
        System.out.println(bin);

        /*
         * Сдвиг влево на N позиций эквивалентен умножению числа на 2N.
         * А сдвиг вправо аналогичен такому же делению.Таким образом, 5<<2 == 5*Math.pow(2,2)*/
        System.out.println(3 << 2); //12
        System.out.println(12 >> 2); //3

        /*проверка на четность*/
        int x = 5;
        System.out.println((x & 1) != 1);

        /*побитовый сдвиг*/
        System.out.println(-14 >>> 1);
    }
}
