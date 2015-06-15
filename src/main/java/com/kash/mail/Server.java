package com.kash.mail;

/**
 * Created with IntelliJ IDEA.
 * User: 123
 * Date: 6/7/15
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class Server implements Quote {

    public Server() {
    }

    public String getQuoted() {
        Random r = new Random();
        int ranQuoteNumber = r.nextInt(QUOTES.length);
        return QUOTES[ranQuoteNumber];
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Quote stub = (Quote) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Quote", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static final String[] QUOTES = {
            "Life isn't about getting and having, it's about giving and being. –Kevin Kruse",
            "Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill",
            "Strive not to be a success, but rather to be of value. –Albert Einstein",
            "Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference.  –Robert Frost",
            "I attribute my success to this: I never gave or took any excuse. –Florence Nightingale",
            "You miss 100% of the shots you don’t take. –Wayne Gretzky",
            "I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed. –Michael Jordan",
            "The most difficult thing is the decision to act, the rest is merely tenacity. –Amelia Earhart",
            "Every strike brings me closer to the next home run. –Babe Ruth",
            "Be yourself; everyone else is already taken.― Oscar Wilde",
            "A room without books is like a body without a soul. ― Marcus Tullius Cicero",
            "Be the change that you wish to see in the world. ― Mahatma Gandhi",
            "If you tell the truth, you don't have to remember anything. ― Mark Twain",
            "If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals.― J.K. Rowling",
            "To live is the rarest thing in the world. Most people exist, that is all.― Oscar Wilde",
            "Without music, life would be a mistake. ― Friedrich Nietzsche",
            "Always forgive your enemies, nothing annoys them so much. ― Oscar Wilde",
            "Life isn't about getting and having, it's about giving and being. –Kevin Kruse",
            "Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill",
            "Strive not to be a success, but rather to be of value. –Albert Einstein"
    };
}
