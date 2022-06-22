import CheckBox from '../../common/CheckBox';
import * as S from './style';

function IssueMenuBar() {
  return (
    <S.Container>
      <S.Wrapper1>
        <CheckBox />
        <S.IssueButton type="button" content="열린 이슈(2)" />
        <S.IssueButton type="button" content="닫힌 이슈(0)" />
      </S.Wrapper1>
      <S.Wrapper2>
        <S.SortButton type="button" content="담당자 ▽" />
        <S.SortButton type="button" content="레이블 ▽" />
        <S.SortButton type="button" content="마일스톤 ▽" />
        <S.SortButton type="button" content="작성자 ▽" />
      </S.Wrapper2>
    </S.Container>
  );
}

export default IssueMenuBar;
