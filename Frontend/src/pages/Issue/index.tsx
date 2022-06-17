/* eslint-disable import/no-extraneous-dependencies */
import { useParams } from 'react-router';

export default function Issue() {
  const params = useParams();
  return <h1>이슈 {params.id}</h1>;
}
