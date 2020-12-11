package com.company;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.SimpleBeanInfo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

    public static void writeToFile(SubscriptionPlan plan) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File ("plan.xml"), new SimpleBeanInfo());

        File file = new File("src/main/resources/plan.xml");

        try {
            xmlMapper.writeValue(file, plan);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SubscriptionPlan readFromFile() {
        XmlMapper xmlMapper = new XmlMapper();

        try {
            String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/plan.xml")));
            SubscriptionPlan subscriptionPlan = xmlMapper.readValue(xml, SubscriptionPlan.class);
            return subscriptionPlan;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
