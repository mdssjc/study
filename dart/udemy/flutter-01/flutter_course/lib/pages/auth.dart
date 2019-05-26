import 'package:flutter/material.dart';

class AuthPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _AuthPageState();
  }
}

class _AuthPageState extends State<AuthPage> {
  String username;
  String password;
  String helpMessage = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Container(
        margin: EdgeInsets.all(10.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextField(
              decoration: InputDecoration(labelText: 'Username'),
              onChanged: (String value) {
                setState(() {
                  username = value.trim();
                });
              },
            ),
            TextField(
              decoration: InputDecoration(labelText: 'Password'),
              obscureText: true,
              onChanged: (String value) {
                setState(() {
                  password = value.trim();
                });
              },
            ),
            SizedBox(
              height: 6.0,
            ),
            Text(helpMessage,
                style: TextStyle(
                  color: Colors.red,
                  fontWeight: FontWeight.bold,
                )),
            SizedBox(
              height: 6.0,
            ),
            RaisedButton(
              child: Text('LOGIN'),
              color: Theme.of(context).accentColor,
              textColor: Colors.white,
              onPressed: () {
                if (isAuth()) {
                  Navigator.pushReplacementNamed(context, "/");
                } else {
                  setState(() {
                    helpMessage = 'Login invalid, try again!';
                  });
                }
              },
            ),
          ],
        ),
      ),
    );
  }

  bool isAuth() {
    return this.username == 'MDS' && this.password == '123';
  }
}
