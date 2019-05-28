import 'package:flutter/material.dart';

class AuthPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _AuthPageState();
  }
}

class _AuthPageState extends State<AuthPage> {
  String email;
  String password;
  String helpMessage = '';
  bool _acceptTerms = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Login'),
      ),
      body: Container(
        margin: EdgeInsets.all(10.0),
        child: ListView(
          children: <Widget>[
            TextField(
              decoration: InputDecoration(labelText: 'E-mail'),
              onChanged: (String value) {
                setState(() {
                  email = value.trim();
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
            SwitchListTile(
              value: _acceptTerms,
              onChanged: (bool value) {
                setState(() {
                  _acceptTerms = value;
                });
              },
              title: Text('Accept Terms'),
            ),
            SizedBox(
              height: 6.0,
            ),
            Text(helpMessage,
                textAlign: TextAlign.center,
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
    return this.email == 'mdssjc@github.com' && this.password == '123';
  }
}
