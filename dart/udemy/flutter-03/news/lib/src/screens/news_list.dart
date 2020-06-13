import 'package:flutter/material.dart';
import 'package:news/src/blocs/stories_provider.dart';

class NewsList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final bloc = StoriesProvider.of(context);
    bloc.fetchTopIds();

    return Scaffold(
      appBar: AppBar(
        title: Text('Top News'),
      ),
      body: _buildList(bloc),
    );
  }

  Widget _buildList(StoriesBloc bloc) {
    return StreamBuilder(
      stream: bloc.topIds,
      builder: (context, AsyncSnapshot<List<int>> snapshot) {
        if (!snapshot.hasData) {
          return Text('Still waiting on Ids');
        }

        return ListView.builder(
          itemCount: snapshot.data.length,
          itemBuilder: (context, index) {
            return Text('$snapshot.data[index]');
          },
        );
      },
    );
  }
}
