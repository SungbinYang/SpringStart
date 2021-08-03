package me.sungbin.design.proxy;

public class ProxyTest {
    public static void main(String[] args) {

//        Chrome chrome = new Chrome("www.naver.com");
//        chrome.show();
//        chrome.show();
//        chrome.show();
//        chrome.show();

        Browser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        browser.show();


    }
}
