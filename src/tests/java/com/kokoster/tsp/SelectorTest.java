package com.kokoster.tsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kokoster on 09/02/2017.
 */
public class SelectorTest {

    @Test
    public void testSelectParents() throws Exception {
        PathValues values =  new PathValues(3);
        values.setValue(0, 1, 1.0);
        values.setValue(0, 2, 2.0);
        values.setValue(1, 0, 3.0);
        values.setValue(1, 2, 4.0);
        values.setValue(2, 0, 5.0);
        values.setValue(2, 1, 6.0);

        ArrayList<Path> paths = new ArrayList<>();
        
        paths.add(new Path(1, 2, 0)); // 10
        paths.add(new Path(0, 1, 2)); // 10
        paths.add(new Path(2, 0, 1)); // 10
        paths.add(new Path(2, 1, 0)); // 11

        Selector selector = new Selector();
        ArrayList<Path> parents = selector.selectParents(paths, values);

        ArrayList<Path> expectedParents =
                new ArrayList<>(Arrays.asList(new Path(1, 2, 0), new Path(0, 1, 2)));

        assertEquals(expectedParents, parents);
    }

    @Test
    public void testSelectSurvival() throws Exception {
        PathValues values =  new PathValues(3);
        values.setValue(0, 1, 1.0);
        values.setValue(0, 2, 2.0);
        values.setValue(1, 0, 3.0);
        values.setValue(1, 2, 4.0);
        values.setValue(2, 0, 5.0);
        values.setValue(2, 1, 6.0);

        ArrayList<Path> paths = new ArrayList<>();

        paths.add(new Path(1, 2, 0)); // 10
        paths.add(new Path(0, 1, 2)); // 10
        paths.add(new Path(2, 0, 1)); // 10
        paths.add(new Path(2, 1, 0)); // 11

        Selector selector = new Selector();
        ArrayList<Path> parents = selector.selectSurvived(paths, values, 2);

        ArrayList<Path> expectedParents =
                new ArrayList<>(Arrays.asList(new Path(1, 2, 0), new Path(0, 1, 2)));

        assertEquals(expectedParents, parents);
    }
}