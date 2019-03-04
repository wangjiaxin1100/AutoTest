package com.oocl;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runnable;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Runner.running;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TestMoco {

    @Test
    public void should_response_as_expected() throws Exception {
        // prepare a mock server
        HttpServer server = httpServer(8811);
        server.response("foo");

        running(server, new Runnable() {
            public void run() throws IOException {
                Content content = Request.Get("http://localhost:8811").execute().returnContent();
                assertThat(content.asString(), is("foo"));
            }
        });
    }
}