package com.kokoster.tsp.Models;

import com.kokoster.tsp.Models.Path;

/**
 * Created by kokoster on 21/02/2017.
 */
public interface PathFoundListener {
    void onNewPathFound(Path path);
}
