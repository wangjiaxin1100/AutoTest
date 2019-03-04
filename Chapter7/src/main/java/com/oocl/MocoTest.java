package com.oocl;
import com.github.dreamhead.moco.Moco;
import com.github.dreamhead.moco.junit.MocoJunitRunner;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MocoTest {
    @Rule
    public MocoJunitRunner runner = MocoJunitRunner.jsonHttpRunner(8811, Moco.pathResource("foo.json"));

    @Test
    public void testNoUri() throws IOException {
        Content content = Request.Get("http://localhost:8811").execute().returnContent();
        assertThat(content.asString(), is("Hello, Moco"));
    }

    @Test
    public void testWithParamAndHeader() throws IOException {
        HttpResponse httpResponse = Request.Get("http://localhost:8811/hust?param=zw").execute().returnResponse();
        assertThat(httpResponse.getFirstHeader("SelfHeader").getValue(), is("SelfHeader"));
    }
}