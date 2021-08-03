package me.sungbin.design.aop;

import me.sungbin.design.proxy.Browser;
import me.sungbin.design.proxy.Html;

public class AopBrowser implements Browser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if (html == null) {
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();
        System.out.println("AopBrowser html use cache : " + url);
        return html;
    }
}
