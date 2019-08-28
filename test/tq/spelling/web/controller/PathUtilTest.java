package tq.spelling.web.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathUtilTest {

    @Test
    public void prepareActionName() {
        //given
        String path = "/simple.act";
        //when
        String result = PathUtil.prepareActionName(path);

        //that
        String expected = "simple";
        assertEquals(expected, result);

    }
}