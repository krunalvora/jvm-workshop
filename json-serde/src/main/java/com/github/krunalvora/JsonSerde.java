package com.github.krunalvora;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonSerde {

  public static void main(String[] args) throws IOException {
    Staff staff = createStaff();
    byte[] jsonBytes = serialize(staff);
    Staff deserializedStaff = deserialize(jsonBytes);
    // System.out.println(deserializedStaff.toString());
    // deserializeUsingJsonNode(jsonBytes);
    printJsonBytesAsString(jsonBytes);
  }


  public static byte[] serialize(Staff staff) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(staff);
    String prettyJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonString);
    byte[] jsonBytes = mapper.writeValueAsBytes(staff);
    return jsonBytes;
  }


  public static Staff deserialize(byte[] jsonBytes) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Staff staff = mapper.readValue(jsonBytes, Staff.class);
    return staff;
  }

  public static void deserializeUsingJsonNode(byte[] jsonBytes) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(jsonBytes);
    System.out.println(jsonNode.get("name").asText());
  }

  public static void printJsonBytesAsString(byte[] jsonBytes) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(jsonBytes);
    String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
    System.out.println(String.format("Staff JSON String: %s", jsonString));
    JsonNode nameNode = jsonNode.at("/salary/2018");
    System.out.println(String.format("2018 Salary: %s", nameNode.asText()));
  }


  private static Staff createStaff() {
    Staff staff = new Staff();
    staff.setName("mkyong");
    staff.setAge(38);
    staff.setPosition(new String[]{"Founder", "CTO", "Writer"});
    Map<String, BigDecimal> salary = new HashMap() {{
      put("2010", new BigDecimal(10000));
      put("2012", new BigDecimal(12000));
      put("2018", new BigDecimal(14000));
    }};
    staff.setSalary(salary);
    staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));
    return staff;
  }
}
