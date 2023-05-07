package com.test.automation.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ResponseContainer {

private long CategoryId;
private String Name;
private String CanRelist;
private int[] AllowedDurations;
private Promotions[] Promotions;


}
