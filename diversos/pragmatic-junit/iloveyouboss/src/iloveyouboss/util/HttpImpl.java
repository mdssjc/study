package iloveyouboss.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpImpl implements Http {

  @Override
  public String get(final String url) throws IOException {
    final CloseableHttpClient client = HttpClients.createDefault();
    final HttpGet request = new HttpGet(url);
    final CloseableHttpResponse response = client.execute(request);
    try {
      final HttpEntity entity = response.getEntity();
      return EntityUtils.toString(entity);
    } finally {
      response.close();
    }
  }
}
