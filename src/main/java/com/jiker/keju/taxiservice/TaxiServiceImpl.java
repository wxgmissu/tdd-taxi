package com.jiker.keju.taxiservice;

import com.jiker.keju.fileutils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxg
 * @creat 2020-03-01 15:57
 */
public class TaxiServiceImpl implements TaxiService {
    @Override
    public String taxiChargeRule(List<String> taxiInput) {
        String taxiContent="";
        for (String input : taxiInput) {
            FileUtil fileUtil = new FileUtil();
            List<String> realTaxiInput = fileUtil.judgeTaxiInput(input);
            double cost = getTaxiCost(realTaxiInput.get(0), realTaxiInput.get(1));
            String costDesc ="收费" + Math.round(cost) + "元\n";
            taxiContent = taxiContent+costDesc;
        }return taxiContent; }

    public double getTaxiCost(String mile, String waitTime) {
        double cost = 0;
        if (Integer.parseInt(mile) <= 2) {
            cost = 6 + 0.25 * Integer.parseInt(waitTime);
        } else if (Integer.parseInt(mile) > 2 && Integer.parseInt(mile) <= 8) {
            cost = 6 + (Integer.parseInt(mile) - 2) * 0.8 + 0.25 * Integer.parseInt(waitTime);
        } else if ((Integer.parseInt(mile) > 8)) {
            cost = 6 + 6 * 0.8 + (Integer.parseInt(mile) - 8) * 1.2 + 0.25 * Integer.parseInt(waitTime);
        }return cost; }

}
