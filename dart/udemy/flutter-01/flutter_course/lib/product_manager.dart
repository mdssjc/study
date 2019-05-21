import 'package:flutter/material.dart';
import 'product_control.dart';
import 'products.dart';

class ProductManager extends StatelessWidget {
  final List<Map<String, String>> products;
  final Function addProduct;
  final Function deleleProduct;

  ProductManager(this.products, this.addProduct, this.deleleProduct);

  @override
  Widget build(BuildContext context) {
    print('[ProductManager State] build()');
    return Column(
      children: [
        Container(
          margin: EdgeInsets.all(10.0),
          child: ProductControl(addProduct),
        ),
        Expanded(child: Products(products, deleteProduct: deleleProduct)),
      ],
    );
  }
}
