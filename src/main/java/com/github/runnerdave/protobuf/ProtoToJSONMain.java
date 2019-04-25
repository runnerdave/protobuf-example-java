package com.github.runnerdave.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;
import java.util.Arrays;

public class ProtoToJSONMain {
    public static void main(String[] args) {
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("My simple message name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        try {
            //Print as a JSON
            String jsonString = JsonFormat.printer().print(builder);
            System.out.println(jsonString);

//            parse JSON into protobuf
            SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
            JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder2);
            System.out.println(builder2);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
