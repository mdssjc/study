package com.github.mdssjc.mja.cap15;

import com.github.mdssjc.mja.cap15.v3.Functions;

public class CallbackStyleExample {

    public static void main(String[] args) {
        int x = 1337;
        Result result = new Result();

        Functions.f(x, y -> {
            result.left = y;
            System.out.println(result.left + result.right);
        });

        Functions.g(x, z -> {
            result.right = z;
            System.out.println(result.left + result.right);
        });
    }
}
