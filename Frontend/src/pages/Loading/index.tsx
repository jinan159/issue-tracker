import * as S from './style';

const LOADING = 'Loading...';

function Loading() {
  return (
    <S.Container>
      <S.Content>{LOADING}</S.Content>
      <S.LoadingSpinner />
    </S.Container>
  );
}

export default Loading;
