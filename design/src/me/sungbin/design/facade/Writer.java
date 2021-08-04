package me.sungbin.design.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void write() {
        String msg = String.format("Writer %s로 파일쓰기를 합니다.", fileName);
        System.out.println(msg);
    }

    public void fileConnect() {
        String msg = String.format("Writer %s의 내용을 읽어 옵니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisConnect() {
        String msg = String.format("Writer %s로 연결을 종료합니다.", fileName);
        System.out.println(msg);
    }
}
