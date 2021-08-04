package me.sungbin.design.facade;

public class FacadeTest {
    public static void main(String[] args) {

        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.html");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.html");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisConnect();
        writer.fileDisConnect();
        ftpClient.disConnect();

        System.out.println("========================");

        FacadeClient facadeClient = new FacadeClient("www.foo.co,kr", 22, "/home/etc", "text.html");
        facadeClient.connect();
        facadeClient.write();
        facadeClient.read();
        facadeClient.disConnect();
    }
}
