package com.lssjzmn.netty;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class TcpHandler implements Runnable {

    private SocketChannel socketChannel;
    private SelectionKey selectionKey;

    private ThreadLocal<Integer> state;

    public TcpHandler(SocketChannel socketChannel, SelectionKey selectionKey) {
        this.socketChannel = socketChannel;
        this.selectionKey = selectionKey;
        state = new ThreadLocal<>();
        state.set(0);
    }

    @Override
    public void run() {

    }
}
