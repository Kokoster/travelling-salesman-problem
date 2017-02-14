package com.kokoster.tsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kokoster on 11/02/2017.
 */
public class CrossoverManagerTest {

    @Test
    public void testDoCrossover() throws Exception {
        ArrayList<ArrayList<Double>> arrayValues = new ArrayList<>();
        arrayValues.add(new ArrayList<>(Arrays.asList(999.0, 75.0, 99.0, 9.0, 35.0, 63.0, 8.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(51.0, 999.0, 86.0, 46.0, 88.0, 29.0, 20.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(100.0, 5.0, 999.0, 16.0, 28.0, 35.0, 28.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(20.0, 45.0, 11.0, 999.0, 59.0, 53.0, 49.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(86.0, 63.0, 33.0, 65.0, 999.0, 76.0, 72.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(36.0, 53.0, 89.0, 31.0, 21.0, 999.0, 52.0)));
        arrayValues.add(new ArrayList<>(Arrays.asList(58.0, 31.0, 43.0, 67.0, 52.0, 60.0, 999.0)));

        PathValues values = new PathValues(7);
        values.setValues(arrayValues);

        Path firstParent = new Path(0, 4, 6, 2, 5, 3, 1);
        Path secondParent = new Path(0, 5, 1, 3, 2, 4, 6);

        Random rand = mock(Random.class);
        when(rand.nextInt(firstParent.size())).thenReturn(0).thenReturn(1).thenReturn(1).thenReturn(2).thenReturn(2).thenReturn(5);

        CrossoverManager crossoverManager = new CrossoverManager(rand);
        Path child = crossoverManager.doCrossover(firstParent, secondParent, values);

        Path expectedChild = new Path(0, 4, 6, 1, 3, 2, 5);

//        System.out.println("First parent: " + firstParent + " : " + firstParent.calculateFitness(values));
//        System.out.println("Second parent: " + secondParent + " : " + secondParent.calculateFitness(values));
//        System.out.println("Child: " + child + " : " + child.calculateFitness(values));

        assertEquals(firstParent.size(), child.size());
        assertEquals(child, expectedChild);
        assertEquals((Double) 266.0, values.calculateFitness(expectedChild));
    }
}