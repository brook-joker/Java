package com.badminton.test;

import com.badminton.tools.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maqiang on 16/10/14.
 */
public class DateTest{
    @Test
    public void getWeek() throws Exception {
        System.out.println(Date.getWeek(2016,6,3));
    }

}