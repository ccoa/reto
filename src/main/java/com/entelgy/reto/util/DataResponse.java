package com.entelgy.reto.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataResponse {

    private List<String> data;

    public void addItemData(String item) {
        if (data == null)
            data = new ArrayList<>();

        data.add(item);
    }

}
