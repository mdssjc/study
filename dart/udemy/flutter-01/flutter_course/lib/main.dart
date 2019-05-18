import 'package:flutter/material.dart';
import 'package:flutter_course/pages/auth.dart';
// import 'package:flutter/rendering.dart';
import 'product_manager.dart';

main() {
  // debugPaintSizeEnabled = true;
  // debugPaintBaselinesEnabled = true;
  // debugPaintPointersEnabled = true;
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // debugShowMaterialGrid: true,
      theme: ThemeData(
          brightness: Brightness.light,
          primaryColor: Colors.deepOrange,
          accentColor: Colors.deepPurple),
      home: AuthPage(),
    );
  }
}
