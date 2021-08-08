package me.sungbin.iocspring;

@FunctionalInterface
public interface IEncoder {
    String encode(String message);
}