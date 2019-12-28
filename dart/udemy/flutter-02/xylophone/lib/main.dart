import 'package:audioplayers/audio_cache.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(XylophoneApp());

class XylophoneApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Column(
            children: <Widget>[
              buildFlatButton(1, Colors.red),
              buildFlatButton(2, Colors.orange),
              buildFlatButton(3, Colors.yellow),
              buildFlatButton(4, Colors.green),
              buildFlatButton(5, Colors.teal),
              buildFlatButton(6, Colors.blue),
              buildFlatButton(7, Colors.purple),
            ],
          ),
        ),
      ),
    );
  }

  void playSound(int soundNumber) {
    final player = AudioCache();
    player.play('note$soundNumber.wav');
  }

  Widget buildFlatButton(int soundNumber, Color color) {
    return FlatButton(
      onPressed: () => playSound(soundNumber),
      color: color,
      child: null,
    );
  }
}
