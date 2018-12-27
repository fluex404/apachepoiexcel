package com.fluex404.apachepoiexcel.plugin;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;

public class MyPlugin {

    public int Rowlength(Iterator<Row> iterator) {
        int size=0;
        while(iterator.hasNext()) {
            Row row = iterator.next();
            size+=1;
        }
        return size;
    }

}
