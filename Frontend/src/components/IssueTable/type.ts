import { Dispatch, SetStateAction } from 'react';

type author = {
  id: number;
  name: string;
  profileImageUrl: string;
};

type labels = {
  id: number;
  title: string;
  color: string;
};

type assignees = {
  id?: number;
  name: string;
  profileImageUrl: string;
};

export type IssueType = {
  id: number;
  title: string;
  author: author;
  createdAt: string;
  mileStoneTitle: string;
  labels: labels[];
  assignees: assignees[];
};

export type IssueData = {
  openIssueCount?: number;
  closedIssueCount?: number;
  issues?: IssueType[];
};

export type IssueStatus = 'OPEN' | 'CLOSE';

export type IssueMenuBarProps = {
  issueData: IssueData;
  setIssueStatus: Dispatch<SetStateAction<IssueStatus>>;
};

export type IssueListProps = {
  issueData: IssueData;
};

export type IssueItemProps = {
  issue: IssueType;
};
