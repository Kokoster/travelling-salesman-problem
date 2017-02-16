package com.kokoster.tsp;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by kokoster on 12/02/2017.
 */
public class MutationManagerTest {

    @Test
    public void testMutate() throws Exception {
        Path child = new Path(0, 1, 2, 3, 4);

        Random rand = mock(Random.class);
        when(rand.nextInt(child.size() - 1)).thenReturn(1).thenReturn(3);

        MutationManager mutationManager = new MutationManager(rand);
        mutationManager.mutate(child);

        Path expectedChild = new Path(0, 1, 4, 3, 2);

        assertEquals(child, expectedChild);
    }

    @Test
    public void testMutateSame() throws Exception {
        Path child = new Path(0, 1, 2, 3, 4);

        Random rand = mock(Random.class);
        when(rand.nextInt(child.size())).thenReturn(2).thenReturn(2);

        MutationManager mutationManager = new MutationManager(rand);
        mutationManager.mutate(child);

        assertEquals(child, child);
    }
}