package com.github.mdssjc.algorithms.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * TestDrives Annotation.
 * 
 * @author Marcelo dos Santos
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestDrives {

  TestDrive[] value();
}
