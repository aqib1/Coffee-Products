package com.accenture.io.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class FileHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T fromJson(String json, Class<T> reference)
            throws JsonProcessingException {
        return MAPPER.readValue(json, reference);
    }

    public <T> T fromJson(String json, TypeReference<T> reference)
            throws JsonProcessingException {
        return MAPPER.readValue(json, reference);
    }

    public String readJsonFromFile(String filePath) throws URISyntaxException, IOException {
        File file = ResourceUtils.getFile("classpath:"+ filePath);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            char[] json = new char[(int)file.length()];
            bufferedReader.read(json);
            return new String(json);
        }
    }
}
