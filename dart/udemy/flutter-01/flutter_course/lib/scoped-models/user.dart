import 'package:flutter_course/models/user.dart';
import 'package:flutter_course/scoped-models/connected_products.dart';

mixin UserModel on ConnectedProductsModel {
  void login(String email, String password) {
    authenticatedUser = User(id: 'qwert', email: email, password: password);
  }
}
