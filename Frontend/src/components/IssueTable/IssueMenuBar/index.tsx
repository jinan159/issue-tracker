import React from 'react';

import Button from '@/components/Button';
import { IssueMenuBarProps } from '@/components/IssueTable/type';

import CheckBox from '../../common/CheckBox';
import * as S from './style';

function IssueMenuBar({ issueData, setIssueStatus }: IssueMenuBarProps) {
  const { openIssueCount, closedIssueCount } = issueData;

  return (
    <S.Container>
      <S.Wrapper1>
        <CheckBox />
        <Button
          buttonStyle="mediumText"
          iconType="alert"
          contents={`열린 이슈 (${openIssueCount})`}
          onClick={() => setIssueStatus('OPEN')}
        />
        <Button
          buttonStyle="mediumText"
          iconType="archive"
          contents={`닫힌 이슈 (${closedIssueCount})`}
          onClick={() => setIssueStatus('CLOSE')}
        />
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
