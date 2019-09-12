import 'package:flutter/material.dart';
import 'package:flutter_complete_guide_4/providers/cart.dart';
import 'package:flutter_complete_guide_4/providers/products.dart';
import 'package:flutter_complete_guide_4/screens/cart_screen.dart';
import 'package:flutter_complete_guide_4/screens/product_detail_screen.dart';
import 'package:flutter_complete_guide_4/screens/products_overview_screen.dart';
import 'package:provider/provider.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider.value(value: Products()),
        ChangeNotifierProvider.value(value: Cart()),
      ],
      child: MaterialApp(
        title: 'MyShop',
        theme: ThemeData(
          primarySwatch: Colors.purple,
          accentColor: Colors.deepOrange,
          fontFamily: 'Lato',
        ),
        home: ProductsOverviewScreen(),
        routes: {
          ProductDetailScreen.routeName: (ctx) => ProductDetailScreen(),
          CartScreen.routeName: (ctx) => CartScreen(),
        },
      ),
    );
  }
}
