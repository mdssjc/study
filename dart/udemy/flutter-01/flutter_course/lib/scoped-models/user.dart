import 'package:flutter_course/models/user.dart';
import 'package:scoped_model/scoped_model.dart';

class UserModel extends Model {
  User _authenticatedUser;

  void login(String email, String password) {
    _authenticatedUser = User(id: 'qwert', email: email, password: password);
  }
}
