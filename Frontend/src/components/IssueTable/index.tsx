import IssueList from './IssueList';
import IssueMenuBar from './IssueMenuBar';
import * as S from './style';

function IssueTable() {
  const issueList: string[] = ['issue'];

  return (
    <S.Container>
      <IssueMenuBar />
      <IssueList issueList={issueList} />
    </S.Container>
  );
}

export default IssueTable;
