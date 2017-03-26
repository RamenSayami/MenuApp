package com.example.ramen.menu.Model;

import java.io.Serializable;

/**
 * Created by ramen on 3/23/17.
 */

public class IdentifySelf implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
