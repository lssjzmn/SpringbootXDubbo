package com.lssjzmn.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class TcpReactor implements Runnable {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    public TcpReactor(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress(port);
        serverSocketChannel.socket().bind(addr);
        serverSocketChannel.configureBlocking(false);
        SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor(serverSocketChannel, selector));

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("waitting for new event on port:" + serverSocketChannel.socket().getLocalPort());
            try {
                if (selector.select(2000) == 0) {
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            while (selectionKeys.iterator().hasNext()) {
                dispatch(selectionKeys.iterator().next());
                selectionKeys.iterator().remove();
            }
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        if (runnable != null) {
            runnable.run();
        }
    }
}
