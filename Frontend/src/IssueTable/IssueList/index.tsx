import IssueItem from '../IssueItem';
import * as S from './style';

type IssueListProps = {
  issueList: string[];
};

function IssueList({ issueList }: IssueListProps) {
  if (issueList.length === 0) {
    return <S.ZeroList>There are not any issues</S.ZeroList>;
  }

  return <IssueItem />;
}

export default IssueList;
