package com.github.mdssjc.algorithms.utils;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TestDrive Annotation.
 * 
 * @author Marcelo dos Santos
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TestDrives.class)
public @interface TestDrive {

  String[] value() default { "" };

  boolean valueFile() default false;

  String[] input() default {  };

  boolean inputFile() default false;
}
