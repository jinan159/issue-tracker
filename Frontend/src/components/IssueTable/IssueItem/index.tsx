import CheckBox from '../../common/CheckBox';
import * as S from './style';

function IssueItem() {
  return (
    <S.Container>
      <S.Wrapper1>
        <CheckBox />
        <S.Wrapper2>
          <S.Wrapper3>
            <S.Title>이슈제목</S.Title>
            <S.Label color="#F7F7FC">라벨</S.Label>
          </S.Wrapper3>
          <S.Wrapper3>
            <S.Content>이슈번호</S.Content>
            <S.Content>타임스탬프</S.Content>
            <S.Content>마일스톤</S.Content>
          </S.Wrapper3>
        </S.Wrapper2>
      </S.Wrapper1>
      <S.Icon>이미지</S.Icon>
    </S.Container>
  );
}

export default IssueItem;
