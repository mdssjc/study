import 'package:rxdart/rxdart.dart';

class StoriesBloc {
  final _topIds = PublishSubject<List<int>>();

  Observable<List<int>> get topIds => _topIds.stream;

  dispose() {
    _topIds.close();
  }
}
