import axios, { AxiosResponse } from 'axios';
import { useEffect, useState } from 'react';

import { IssueData, IssueStatus } from '@/components/IssueTable/type';

import IssueList from './IssueList';
import IssueMenuBar from './IssueMenuBar';
import * as S from './style';

export default function IssueTable() {
  const [issueData, setIssueData] = useState<IssueData>({});
  const [issueStatus, setIssueStatus] = useState<IssueStatus>('OPEN');

  useEffect(() => {
    const getData = async () => {
      const response: AxiosResponse = await axios.get(
        `${process.env.MOCK_URL}=${issueStatus}`
      );
      setIssueData(response.data);
    };
    getData();
  }, [issueStatus]);

  return (
    <S.Container>
      <IssueMenuBar issueData={issueData} setIssueStatus={setIssueStatus} />
      <IssueList issueData={issueData} />
    </S.Container>
  );
}
