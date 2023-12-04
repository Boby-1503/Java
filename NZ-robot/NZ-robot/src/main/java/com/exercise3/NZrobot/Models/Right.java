package com.exercise3.NZrobot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Right
{
    private long id;
    private boolean isOpponent;
    private List<Classification> classification;
    private String name;
    private String type;
    private String reference;

}
