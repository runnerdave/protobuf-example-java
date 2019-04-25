package com.github.runnerdave.protobuf;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        builder.addMultipleDummy(newDummyMessage(66, "second dummy"));
        builder.addMultipleDummy(newDummyMessage(67, "third dummy"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(68, "fourth dummy"),
                newDummyMessage(69, "fifth dummy")
        ));

        System.out.println(builder.build());

        System.out.printf("Size of dummyList: %d", builder.build().getMultipleDummyList().size());
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyMessageBuilder.setName("Name")
                .setId(id)
                .setName(name)
                .build();

        return message;
    }
}
