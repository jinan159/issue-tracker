import axios, { AxiosResponse } from 'axios';
import { useEffect, useState } from 'react';

import { CheckedIssueIdProvider } from '@/components/IssueTable/CheckedIssueIdProvider';
import { IssueData, IssueStatus } from '@/components/IssueTable/type';

import IssueList from './IssueList';
import IssueMenuBar from './IssueMenuBar';
import * as S from './style';

const POSTMAN = 'https://cbcaf3d6-e50d-4fd6-b390-7f1fb822cc93.mock.pstmn.io';
const API_URL = 'api/issuegroup/1/issues';

export default function IssueTable() {
  // TODO : issue data 전역으로 분리
  const [issueData, setIssueData] = useState<IssueData>({
    closedIssueCount: 0,
    openIssueCount: 0,
    issues: [],
  });
  const [issueStatus, setIssueStatus] = useState<IssueStatus>('OPEN');
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const getData = async () => {
      const response: AxiosResponse = await axios.get(`${POSTMAN}/${API_URL}`, {
        params: { page: 1, pageSize: 10, status: issueStatus },
      });
      setIssueData(response.data);
    };
    getData();
    setIsLoading(false);
  }, [issueStatus]);

  return (
    <CheckedIssueIdProvider>
      <S.Container>
        <IssueMenuBar issueData={issueData} setIssueStatus={setIssueStatus} />
        {isLoading ? <S.LoadingSpinner /> : <IssueList issueData={issueData} />}
      </S.Container>
    </CheckedIssueIdProvider>
  );
}
