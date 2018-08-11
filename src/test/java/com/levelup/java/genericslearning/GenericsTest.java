package com.levelup.java.genericslearning;
/**
 * Created by wenweizww on 2018/8/11.
 */


import javafx.beans.binding.DoubleExpression;
import org.junit.Test;

import java.util.ArrayList;

/**
 * author:zhou_wenwei
 * mail:zhou_wenwei@wuxiapptec.com
 * date:2018/8/11
 * description:
 */
public class GenericsTest {

    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static <E> void printArrary(E[] array){
        for(E element:array){
            System.out.print( element);
        }
        System.out.println();
    }
    @Test
    public void addGenerics(){
        double[] doubles = {1.1,1.23};
        char[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        printArrary(doubles);
        printArrary(charArray);

        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }

}
