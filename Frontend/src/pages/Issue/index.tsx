import { useParams } from 'react-router-dom';

export default function Issue() {
  const params = useParams();
  return <h1>이슈 {params.id}</h1>;
}
