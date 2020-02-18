import 'package:flutter/material.dart';
import 'package:http/http.dart' show get;

class App extends StatefulWidget {
  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> {
  int counter = 0;

  void fetchImage() {

  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Text('$counter'),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: fetchImage,
        ),
        appBar: AppBar(
          title: Text('Let\'s see some images!'),
        ),
      ),
    );
  }
}
