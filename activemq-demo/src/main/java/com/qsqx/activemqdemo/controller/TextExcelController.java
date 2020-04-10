package com.qsqx.activemqdemo.controller;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class TextExcelController {

    @RequestMapping(value = "/importExcel")
    public void fe_map(HttpServletResponse response) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(dateTimeFormatter);
        TemplateExportParams params = new TemplateExportParams(
                "/templates/cmbc.xlsx", true);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "黄小毛");
        map.put("card", "3546846185461894641");
        map.put("accountMechanism", "中国银行");
        map.put("account", "1602160609000059281");
        map.put("startTime", date);
        map.put("endTime", date);
        map.put("printTime", date);
        List<Map<String, String>> listMap = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> lm = new HashMap<>();
            lm.put("type", i + "卡");
            lm.put("number", i * 10000 + "");
            lm.put("summary", i+"\t 支付宝快捷支付");
            lm.put("date", "2020-02-02");
            int money = new Random().nextInt(100) + i;
            lm.put("money", money+"");
            lm.put("balance", "10"+i);
            lm.put("sign", "转账");
            lm.put("channel", "网络银行");
            lm.put("mechanism", "9001");
            lm.put("accountName", "支付宝（中国）网络技术有限公司客户备付金");
            lm.put("lineName", "10235632494616161");
            listMap.add(lm);
        }
        map.put("mapList", listMap);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("cmbc.xlsx", "UTF-8"));
        workbook.write(response.getOutputStream());

//        File saveFile = new File("E:/excel/");
//        if (!saveFile.exists()) {
//            saveFile.mkdirs();
//        }
//        FileOutputStream fos = new FileOutputStream("E:/excel/cmbc.xls");
//        workbook.write(fos);
//        fos.close();
    }
}