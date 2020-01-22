import 'dart:convert';

import 'package:http/http.dart';

const List<String> currenciesList = [
  'AUD',
  'BRL',
  'CAD',
  'CNY',
  'EUR',
  'GBP',
  'HKD',
  'IDR',
  'ILS',
  'INR',
  'JPY',
  'MXN',
  'NOK',
  'NZD',
  'PLN',
  'RON',
  'RUB',
  'SEK',
  'SGD',
  'USD',
  'ZAR',
];

const List<String> cryptoList = [
  'BTC',
  'ETH',
  'LTC',
];

const bitcoinAverageURL =
    'https://apiv2.bitcoinaverage.com/indices/global/ticker/BTC';

class CoinData {
  Future<double> getCoinData(String selectedCurrency ) async {
    var response = await get('$bitcoinAverageURL$selectedCurrency');

    if (response.statusCode == 200) {
      return jsonDecode(response.body)['last'];
    } else {
      print(response.statusCode);
      throw 'Problem with the get request';
    }
  }
}
