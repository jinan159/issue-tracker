import { IssueListProps, IssueType } from '@/components/IssueTable/type';

import IssueItem from '../IssueItem';
import * as S from './style';

export default function IssueList({ issueData }: IssueListProps) {
  const { issues } = issueData;
  if (!issues) {
    return <S.ZeroList>There are not any issues</S.ZeroList>;
  }

  return (
    <>
      {issues.map((issue: IssueType) => (
        <IssueItem key={issue.id} issue={issue} />
      ))}
    </>
  );
}
