package com.oocl;

import com.github.dreamhead.moco.HttpServer;
import static com.github.dreamhead.moco.Moco.*;


public class Test {
@org.junit.Test
public void  HttpsServer(){
        HttpServer server = httpServer(8899);
        server.request(by(uri("/foo"))).response("bar");
        System.out.println("服务起来了");
            }
        };
