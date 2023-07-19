package com.teamProject.syusyu.domain;

import junit.framework.TestCase;
import org.junit.Test;

public class PageHandler2Test extends TestCase {
    @Test
    public void test() {
        PageHandler2 ph = new PageHandler2(250, 1);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==1);
        assertTrue(ph.getEndPage() ==10);
    }

    @Test
    public void test2() {
        PageHandler2 ph = new PageHandler2(250, 11);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==11);
        assertTrue(ph.getEndPage() ==20);
    }

    @Test
    public void test3() {
        PageHandler2 ph = new PageHandler2(255, 25);
        ph.print();
        System.out.println("ph = " + ph);
        assertTrue(ph.getBeginPage() ==21);
        assertTrue(ph.getEndPage() ==26);
    }
}