package com.xyp.codesnippet.json;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import static javax.json.stream.JsonParser.Event.END_ARRAY;
import static javax.json.stream.JsonParser.Event.END_OBJECT;
import static javax.json.stream.JsonParser.Event.KEY_NAME;
import static javax.json.stream.JsonParser.Event.START_ARRAY;
import static javax.json.stream.JsonParser.Event.START_OBJECT;

/**
 *
 * @author Peter Xu
 */
public class JsonDemo {
    
    /**
     * 
     * @return Json Object 
     */
    public static JsonObject buildJsonWithObjectModel(){
        JsonObject jsonObj;
        jsonObj = Json.createObjectBuilder()
                        .add("name", "Peter Xu")
                        .add("age", 25)
                        .add("tel", Json.createArrayBuilder()
                                       .add("110")
                                       .add("112"))
                        .build();
        return jsonObj;
    }
    
    /**
     * 
     * @return Json String 
     */
    public static String buildJsonWithStreamingAPI(){
        StringWriter sw = new StringWriter();
        Json.createGenerator(sw)
            .writeStartObject()
            .write("name", "Peter Xu")
            .write("age", 25)
            .writeStartArray("tel")
            .write("110")
            .write("112")
            .writeEnd()
            .writeEnd()
            .close();
        return sw.toString();
    }
    
    /**
     * 
     * @return Json String 
     */
    public static String parseJsonWithStreamingAPI(JsonObject jsonObj){
        String jsonStr = jsonObj.toString();
        Reader jsonReader = new StringReader(jsonStr);
        JsonParser jsonParser = Json.createParser(jsonReader);
        StringBuilder sb = new StringBuilder();
        while (jsonParser.hasNext()) {
            Event event = jsonParser.next();
            switch (event) {
                case START_ARRAY:
                    sb.append("[");
                    break;
                case END_ARRAY:
                    sb.replace(sb.length()-1, sb.length(), "],");
                    break;
                case START_OBJECT:
                    sb.append("{");
                    break;
                case END_OBJECT:
                    sb.replace(sb.length()-1, sb.length(), "}");
                    break;
                case KEY_NAME:
                case VALUE_STRING:
                    sb.append("\"").append(jsonParser.getString()).append("\"").append(",");
                    break;
                case VALUE_TRUE:
                case VALUE_FALSE:
                    sb.append(jsonParser.getString()).append(",");//TODO
                    break;
                case VALUE_NUMBER:
                    sb.append(jsonParser.getInt()).append(",");
                    break;
                case VALUE_NULL:
                    sb.append("\"\"").append(",");
                    break;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        JsonObject jsonObj = JsonDemo.buildJsonWithObjectModel();
        System.out.println(jsonObj.toString());
        System.out.println(JsonDemo.buildJsonWithStreamingAPI());
        System.out.println(JsonDemo.parseJsonWithStreamingAPI(jsonObj));
    }
}
