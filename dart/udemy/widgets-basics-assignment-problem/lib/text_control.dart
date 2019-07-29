import 'package:assignment1/text_output.dart';
import 'package:flutter/material.dart';

class TextControl extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _TextControlState();
}

class _TextControlState extends State<TextControl> {
  var _text = 'Hello World';

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Center(
          child: Container(
            margin: EdgeInsets.all(10.0),
            child: RaisedButton(
              onPressed: () {
                setState(() {
                  _text = 'This is Flutter!';
                });
              },
              child: Text('Press me!'),
            ),
          ),
        ),
        TextOutput(_text),
      ],
    );
  }
}
