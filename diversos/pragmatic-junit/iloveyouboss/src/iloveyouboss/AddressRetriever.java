package iloveyouboss;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import iloveyouboss.util.Http;
import iloveyouboss.util.HttpImpl;

public class AddressRetriever {

  private Http http = new HttpImpl();

  public Address retrieve(final double latitude, final double longitude)
      throws IOException, ParseException {
    final String parms = String.format("lat=%.6f&lon=%.6f", latitude,
        longitude);
    final String response = this.http.get(
        "http://open.mapquestapi.com/nominatim/v1/reverse?format=json&"
            + parms);

    final JSONObject obj = (JSONObject) new JSONParser().parse(response);

    final JSONObject address = (JSONObject) obj.get("address");
    final String country = (String) address.get("country_code");
    if (!country.equals("us")) {
      throw new UnsupportedOperationException(
          "cannot support non-US addresses at this time");
    }

    final String houseNumber = (String) address.get("house_number");
    final String road = (String) address.get("road");
    final String city = (String) address.get("city");
    final String state = (String) address.get("state");
    final String zip = (String) address.get("postcode");

    return new Address(houseNumber, road, city, state, zip);
  }
}
