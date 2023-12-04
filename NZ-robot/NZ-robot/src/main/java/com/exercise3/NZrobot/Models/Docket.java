package com.exercise3.NZrobot.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Docket
{
    private Long id;
    private String reference;
    private String courtId;
    private String judge;

    public void setId(Long id) {
        this.id = id;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public Long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getCourtId() {
        return courtId;
    }

    public String getJudge() {
        return judge;
    }
}