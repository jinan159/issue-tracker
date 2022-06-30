import React, { useContext } from 'react';

import Button from '@/components/Button';
import { IssueMenuBarProps } from '@/components/IssueTable/type';
import { CheckedIssueIdContext } from '@/context/CheckedIssueIdProvider';
import { IssueType } from '@/context/IssueDataProvider';

import CheckBox from '../../CheckBox';
import * as S from './style';

function IssueMenuBar({ issueData, setIssueStatus }: IssueMenuBarProps) {
  const { openIssueCount, closedIssueCount, issues } = issueData;
  const { checkedIssueId, dispatch } = useContext(CheckedIssueIdContext);

  const idList = issues.map((issue: IssueType) => issue.id);
  const allChecked =
    idList.every((id) => checkedIssueId.has(id)) && idList.length !== 0;

  const handleChangeAllCheck = () => {
    if (allChecked) {
      return dispatch({ type: 'allClear' });
    }
    return dispatch({ type: 'allCheck', idList });
  };
  return (
    <S.Container>
      <S.Wrapper>
        <CheckBox checked={allChecked} onChange={handleChangeAllCheck} />
        <Button
          buttonStyle="mediumText"
          hasIcon
          iconType="alert"
          contents={`열린 이슈 (${openIssueCount})`}
          onClick={() => setIssueStatus('OPEN')}
        />
        <Button
          buttonStyle="mediumText"
          hasIcon
          iconType="archive"
          contents={`닫힌 이슈 (${closedIssueCount})`}
          onClick={() => setIssueStatus('CLOSED')}
        />
      </S.Wrapper>
      {checkedIssueId.size > 0 ? (
        <Button buttonStyle="sort" hasIcon={false} contents="상태 수정 ▽" />
      ) : (
        <S.Wrapper>
          <Button buttonStyle="sort" hasIcon={false} contents="담당자 ▽" />
          <Button buttonStyle="sort" hasIcon={false} contents="레이블 ▽" />
          <Button buttonStyle="sort" hasIcon={false} contents="마일스톤 ▽" />
          <Button buttonStyle="sort" hasIcon={false} contents="작성자 ▽" />
        </S.Wrapper>
      )}
    </S.Container>
  );
}

export default IssueMenuBar;
