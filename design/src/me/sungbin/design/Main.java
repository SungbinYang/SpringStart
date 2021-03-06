package me.sungbin.design;

import me.sungbin.design.adapter.Electronic110V;
import me.sungbin.design.singleton.AClazz;
import me.sungbin.design.singleton.BClazz;
import me.sungbin.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
