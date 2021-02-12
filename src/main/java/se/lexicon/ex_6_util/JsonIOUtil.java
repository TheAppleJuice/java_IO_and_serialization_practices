package se.lexicon.ex_6_util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.exercise_6.Cars;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIOUtil {

    private ObjectMapper objectMapper;

    public JsonIOUtil(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void serializeCarsListToJson(List<Cars> cars, File file){
        try {
            if (!file.exists())
                file.createNewFile();
            objectMapper.writeValue(file,cars);
            System.out.println("Operation is Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cars> deserializeJsonListToCars(File file){
        List<Cars> result= new ArrayList<>();
        try{
            result = objectMapper.readValue(file, new TypeReference<List<Cars>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /*public Cars deserializeJsonToCars(File file){

        Cars result= new Cars();
        try{
            return objectMapper.readValue(file, new TypeReference<Cars>() {});
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }*/



}
