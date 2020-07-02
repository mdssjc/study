import 'package:news/src/models/item_model.dart';
import 'package:rxdart/rxdart.dart';

class CommentsBloc {
  final _commentsFetcher = PublishSubject<int>();
  final _commentsOutput = BehaviorSubject<Map<int, Future<ItemModel>>>();

  Observable<Map<int, Future<ItemModel>>> get itemWithComments =>
      _commentsOutput.stream;

  Function(int) get fetchItemWithComments => _commentsFetcher.sink.add;

  dispose() {
    _commentsFetcher.close();
    _commentsOutput.close();
  }
}
