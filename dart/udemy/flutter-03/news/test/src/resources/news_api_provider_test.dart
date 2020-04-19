import 'dart:convert';

import 'package:http/http.dart';
import 'package:http/testing.dart';
import 'package:news/resources/news_api_provider.dart';
import 'package:test/test.dart';

void main() {
  test('FetchTopIds returns a list of ids', () async {
    final newsApi = NewsApiProvider();
    newsApi.client = MockClient((request) async {
      return Response(json.encode([1, 2, 3, 4]), 200);
    });

    final ids = await newsApi.fetchTopIds();

    expect(ids, [1, 2, 3, 4]);
  });
}
