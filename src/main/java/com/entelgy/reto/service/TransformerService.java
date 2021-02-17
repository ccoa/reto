package com.entelgy.reto.service;

import com.entelgy.reto.util.DataResponse;
import com.entelgy.reto.util.PostTypicode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class TransformerService {

    private final TypicodeService typicodeService;

    public DataResponse getTransformedData() {
        DataResponse dataResponse = new DataResponse();

        PostTypicode[] postTypicodes = typicodeService.getPosts();

        if (postTypicodes != null) {
            Arrays.stream(postTypicodes).forEach( postTypicode -> {
                String item = String.format("%s\\%s\\%s", postTypicode.getPostId(), postTypicode.getId(), postTypicode.getEmail());
                dataResponse.addItemData(item);
            });
        }

        return dataResponse;
    }

}
