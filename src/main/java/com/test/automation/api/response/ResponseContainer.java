package com.test.automation.api.response;

import lombok.Data;

@Data
public class ResponseContainer {

private long CategoryId;
private String Name;
private String CanRelist;
private int[] AllowedDurations;
private Promotions[] Promotions;


}
