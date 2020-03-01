package com.jiker.keju.taxiservice;

import java.util.List;

/**
 * @author wxg
 * @creat 2020-03-01 15:56
 */
public interface TaxiService {
    /**
     * taxi收费规则
     */
    public List<String> taxiChargeRule(List<String> taxiInput);
}
