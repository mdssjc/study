import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ProductCreatePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _ProductCreatePageState();
  }
}

class _ProductCreatePageState extends State<ProductCreatePage> {
  String titleValue;
  String descriptionValue;
  double priceValue;

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[
        TextField(
          decoration: InputDecoration(labelText: 'Product Title'),
          onChanged: (String value) {
            setState(() {
              titleValue = value;
            });
          },
        ),
        TextField(
          maxLines: 4,
          decoration: InputDecoration(labelText: 'Product Description'),
          onChanged: (String value) {
            setState(() {
              descriptionValue = value;
            });
          },
        ),
        TextField(
          keyboardType: TextInputType.number,
          decoration: InputDecoration(labelText: 'Product Price'),
          onChanged: (String value) {
            setState(() {
              priceValue = double.parse(value);
            });
          },
        ),
        RaisedButton(
          child: Text('Save'),
          onPressed: () {},
        ),
      ],
    );
  }
}
