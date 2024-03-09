package com.heyufei.user.utils;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Demo22 {

    @SneakyThrows
    public static void main(String[] args) {
        String fileDir = "blog-platform/blog-user/src/main/java/com/heyufei/user/utils/workbook.xls";

        List<String> sheetName = new ArrayList<>();

        sheetName.add("A");


        String name = "name";
        String title1 = "title";
        String organizationName = "organization_name";
        String email1 = "email";
        String presentRawAddress = "present_raw_address";
        String sanitizedPhone = "sanitized_phone";

        String[] title = {name, title1, organizationName, email1, presentRawAddress, sanitizedPhone};
        CreateExcelFile.createExcelXls(fileDir, sheetName, title);

        List<Map<String,String>> userList1 = new ArrayList<Map<String,String>>();

        FileInputStream fis = new FileInputStream("F:\\IDEA\\IDEA-Project\\MeteorPavilion\\blog-platform\\blog-user\\src\\test\\java\\1.txt");
        String stringTooLong = IOUtils.toString(fis, "UTF-8");

        String jsonStr = stringTooLong;
        JSONObject jsonObject = new JSONObject(jsonStr);
        JSONArray contactsArray = jsonObject.getJSONArray("contacts");

        for (int i = 0; i < contactsArray.length(); i++) {
            JSONObject contact = contactsArray.getJSONObject(i);

            Map<String,String> map=new HashMap<String,String>();
            map.put(name,contact.getString(name));
            map.put(title1,contact.getString(title1));
            map.put(organizationName,contact.getString(organizationName));
            map.put(email1,contact.getString(email1));
            map.put(presentRawAddress,contact.getString(presentRawAddress));
            map.put(sanitizedPhone,contact.getString(sanitizedPhone));

            userList1.add(map);

        }


        Map<String, List<Map<String, String>>> users = new HashMap<>();

        users.put("A", userList1);


        System.out.println(sheetName.size());

        //删除List 集合中特定的元素
        for(Iterator<String> sheeNameIterator = sheetName.iterator(); sheeNameIterator.hasNext();){

            String sheet = sheeNameIterator.next();

            if ( users.get(sheet).size() == 0) {

                sheeNameIterator.remove();

            }
        }

        System.out.println(sheetName.size());

        CreateExcelFile.createExcelXls(fileDir, sheetName, title);
        for (int j = 0; j < sheetName.size(); j++) {

            try {
                CreateExcelFile.writeToExcelXls(fileDir, sheetName.get(j), users.get(sheetName.get(j)));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }
}
