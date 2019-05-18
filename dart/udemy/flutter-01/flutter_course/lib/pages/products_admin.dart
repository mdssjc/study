import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ProductsAdminPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Manage Products'),
      ),
      body: Center(
        child: Text('Manage your Products'),
      ),
    );
  }
}
