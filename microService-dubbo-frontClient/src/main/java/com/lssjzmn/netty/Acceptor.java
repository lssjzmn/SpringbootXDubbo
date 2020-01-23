package com.lssjzmn.netty;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public Acceptor(ServerSocketChannel serverSocketChannel, Selector selector) {
        this.serverSocketChannel = serverSocketChannel;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println(socketChannel.socket().getRemoteSocketAddress().toString() + " connected");
            if (socketChannel!=null){
                socketChannel.configureBlocking(false);
                SelectionKey sk = socketChannel.register(selector,SelectionKey.OP_READ);
                selector.wakeup();
                sk.attach("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
