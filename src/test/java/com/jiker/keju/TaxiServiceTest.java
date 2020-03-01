package com.jiker.keju;

import com.jiker.keju.fileutils.FileUtil;
import com.jiker.keju.taxiservice.TaxiServiceImpl;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author wxg
 * @creat 2020-03-01 15:58
 */
public class TaxiServiceTest {
    @Test
    public void testTaxiChargeRule() {
        TaxiServiceImpl taxiService = new TaxiServiceImpl();
        List<String> taxiContent = new ArrayList<>();
        taxiContent.add("2lon,nm345");
        String taxiChargeRule = taxiService.taxiChargeRule(taxiContent);
        assertNotNull(taxiChargeRule);
    }

    @Test
    public void testGetTaxiCost() {
        TaxiServiceImpl taxiService = new TaxiServiceImpl();
        double taxiCost = taxiService.getTaxiCost(String.valueOf(2), String.valueOf(3));
        long cost = Math.round(taxiCost);
        assertEquals(7, cost);
    }

    @Test
    public void testReadTaxiInput() {
        FileUtil fileUtil = new FileUtil();
        File file = new File(AppRunner.class.getClassLoader().getResource("testData.txt").getFile());
        List<String> readTaxiInput = fileUtil.readTaxiInput(file.toString());
        assertEquals(4, readTaxiInput.size());
    }

    @Test
    public void testJudgeTaxiInput() {
        String input = "2公里,等待3分钟";
        FileUtil fileUtil = new FileUtil();
        List<String> judgeTaxiInput = fileUtil.judgeTaxiInput(input);
        assertEquals(2, judgeTaxiInput.size());
    }
}
