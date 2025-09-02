package com.springpoc.springbootjsonvalidator.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JsonEscapeUnescapeService {


    public static String escapeJson(String jsonObject){
        jsonObject=santizeJson(jsonObject);
        return StringEscapeUtils.escapeJson(jsonObject);
    }

    public static String unescapeJson(String jsonString){
        ObjectMapper mapper = new ObjectMapper()
                .enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
        String unescapedJson= StringEscapeUtils.unescapeJson(jsonString);
        try{
            mapper.readTree(unescapedJson);
            return unescapedJson;
        }catch (JsonProcessingException e){
            return santizeJson(unescapedJson);
        }
    }


    private static String santizeJson(String invalidJson) {
        String cleaned = invalidJson.trim();
        cleaned = cleaned.replaceAll("^\\{+", "");
        cleaned = cleaned.replaceAll(",*\\}+$", "");
        return cleaned;
    }
}
