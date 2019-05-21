import 'package:flutter/material.dart';
import 'package:flutter_course/pages/products_admin.dart';

import 'pages/products.dart';

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
      //home: AuthPage(),
      routes: {
        '/': (BuildContext context) => ProductsPage(),
        "/admin": (BuildContext context) => ProductsAdminPage(),
      },
    );
  }
}
