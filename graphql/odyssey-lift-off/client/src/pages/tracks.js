import React from 'react';
import { useQuery, gql } from '@apollo/client';
import TrackCard from '../containers/track-card';
import { Layout, QueryResult } from '../components';

const TRACKS = gql`
  query GetTracks {
    tracksForHome {
      id
      title
      thumbnail
      length
      modulesCount
      author {
        name
        photo
      }
    }
  }
`;

const Tracks = () => {
  const { loading, error, data } = useQuery(TRACKS);

  return (
    <Layout grid>
      <QueryResult
        error={error}
        loading={loading}
        data={data}>
        {data?.tracksForHome?.map((track, index) => (
          <TrackCard
            key={track.id}
            track={track}
          />
        ))}
      </QueryResult>
    </Layout>
  );
};

export default Tracks;
