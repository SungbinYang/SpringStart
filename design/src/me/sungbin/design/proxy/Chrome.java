package me.sungbin.design.proxy;

public class Chrome implements Browser {

    private String url;

    public Chrome(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser loading html from : " + url);
        return new Html(url);
    }
}
